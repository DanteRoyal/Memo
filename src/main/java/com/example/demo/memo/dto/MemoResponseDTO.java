package com.example.demo.memo.dto;

import com.example.demo.memo.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoResponseDTO {

    String content;


    public MemoResponseDTO(Memo memo) {
        this.content = memo.getContent();
    }
}
