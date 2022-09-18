package com.kingston.msc.model;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Sandaka Wijesinghe.
 * Date: 9/7/22
 */

@Getter
@Setter
@NoArgsConstructor
@Data
@ToString
public class PostRegistrationStudent {

    private long smsUserId;
    private long registrationId;
    private String fullName;
    private String title;
    private String body;
    private Date postDate;

    private int views;

    // comments list

    private List<String> tagNames;
}
