package com.kingston.msc.webclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 6/26/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int userId;

    private int id;

    private String title;

    private String body;
}
