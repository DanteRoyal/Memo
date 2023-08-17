package com.example.demo.memo;

import com.example.demo.memo.dto.MemoRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String content;

    public Memo() {
    }

    public Memo(MemoRequestDTO memoRequestDTO) {
        this.content = memoRequestDTO.getContent();
    }

    public void update(MemoRequestDTO request) {
        this.content = request.getContent();
    }
}
