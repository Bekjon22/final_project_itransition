package com.itransition.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

/**
 * @author Bekjon Bakhromov
 * @since 05.07.2022
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomPage<T> {
    private Collection<T> content; // Elementlar
    private int numberOfElements;  // Current page dagi elementlar soni
    private int number;            // Current page number
    private long totalElements;    // Barcha elementlar soni
    private int totalPages;        // Barcha page lar soni
    private int size;              // Nechta so'ragani

}
