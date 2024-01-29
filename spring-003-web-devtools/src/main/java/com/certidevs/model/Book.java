package com.certidevs.model;

public record Book(Long id,
                   String title,
                   Double price,
                   Boolean available,
                   Author author
) {
}
