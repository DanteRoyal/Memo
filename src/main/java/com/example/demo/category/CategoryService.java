package com.example.demo.category;

import com.example.demo.category.dto.CategoryDTO;
import com.example.demo.category.entity.Category;
import com.example.demo.category.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Category createCategory(CategoryDTO categoryDTO) {

        Optional<Category> findOne = categoryRepository.findByName(categoryDTO.getName());
        if (findOne.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "중복된 이름입니다");
        }
        Category category = Category.builder()
                .name(categoryDTO.getName())
                        .build();

        category = categoryRepository.save(category);

        return category;
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "카테고리가 존재하지 않습니다")
        );
    }

    public Page<Category> getCategories(Pageable pageable, String keyword) {
        if (keyword == null)
            return categoryRepository.findAll(pageable);
        else
            return categoryRepository.findByNameContains(pageable, keyword);

    }
}
