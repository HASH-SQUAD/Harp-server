package com.hash.harp.domain.survey.domain;

import com.hash.harp.domain.survey.domain.type.Food;
import com.hash.harp.domain.survey.domain.type.Mbti;
import com.hash.harp.domain.survey.domain.type.Travel;
import com.hash.harp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 200)
    private String content;

    @ElementCollection(targetClass = Travel.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "survey_travel", joinColumns = @JoinColumn(name = "survey_id"))
    @Column(name = "travel")
    @Enumerated(EnumType.STRING)
    private List<Travel> travel;

    @ElementCollection(targetClass = Food.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "survey_food", joinColumns = @JoinColumn(name = "survey_id"))
    @Column(name = "food")
    @Enumerated(EnumType.STRING)
    private List<Food> food;

    @Enumerated(EnumType.STRING)
    private Mbti mbti;

    @Column(name = "user_id")
    private Long userId;

    @Builder
    public Survey(List<Travel> travel, List<Food> food, Mbti mbti, String content, Long userId) {
        this.travel = travel;
        this.food = food;
        this.mbti = mbti;
        this.content = content;
        this.userId = userId;
    }
}
