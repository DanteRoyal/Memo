package com.example.demo.memo;

import com.example.demo.memo.dto.MemoRequestDTO;
import com.example.demo.memo.dto.MemoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    @PostMapping
    public void saveMemo(@RequestBody MemoRequestDTO request) {
        memoService.saveMemo(request);
    }

    @GetMapping("/{id}")
    public MemoResponseDTO getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }

    @GetMapping
    public List<MemoResponseDTO> getMemos() {
        return memoService.getMemos();
    }

    @PutMapping
    public void updateMemo(@RequestBody MemoRequestDTO request) {
        memoService.updateMemo(request);
    }
    @DeleteMapping("/{id}")
    public void deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
    }


}
