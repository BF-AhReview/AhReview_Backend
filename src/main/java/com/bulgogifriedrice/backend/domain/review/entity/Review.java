package com.bulgogifriedrice.backend.domain.review.entity;

import com.bulgogifriedrice.backend.domain.auth.entity.User;
import com.bulgogifriedrice.backend.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", nullable = false)
    private User reviewer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_address", nullable = false)
    private Store store;

    private String review;

    private String answer;

    private boolean positive;

    @Min(1)
    @Max(5)
    private double starScore;

    private boolean anonymous;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<Picture> pictureList;

}
