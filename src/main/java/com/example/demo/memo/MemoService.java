package com.example.demo.memo;

import com.example.demo.memo.dto.MemoRequestDTO;
import com.example.demo.memo.dto.MemoResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    public void saveMemo(MemoRequestDTO request) {
        memoRepository.save(new Memo(request));
    }

    @Transactional(readOnly = true)
    public MemoResponseDTO getMemo(Long id) {
        String content = memoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new).getContent();

        return new MemoResponseDTO(content);

    }

    @Transactional(readOnly = true)
    public List<MemoResponseDTO> getMemos() {
        return memoRepository.findAll().stream()
                .map(MemoResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void updateMemo(MemoRequestDTO request) {
        Memo memo = memoRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        memo.update(request);
        memoRepository.save(memo);
    }

    public void deleteMemo(Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(IllegalAccessError::new);

        memoRepository.delete(memo);
    }
}
