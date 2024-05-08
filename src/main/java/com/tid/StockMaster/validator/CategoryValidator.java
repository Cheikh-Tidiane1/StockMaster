package com.tid.StockMaster.validator;

import com.tid.StockMaster.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> CategoryValidator(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<String>();
        if(categoryDto == null || !StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Veuillez renseigner le code de la categorie");
        }
        return errors;
    }
}
