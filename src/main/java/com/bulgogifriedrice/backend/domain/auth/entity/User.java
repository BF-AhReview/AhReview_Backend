package com.bulgogifriedrice.backend.domain.auth.entity;

import com.bulgogifriedrice.backend.domain.review.entity.Review;
import com.bulgogifriedrice.backend.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    private String email;

    @Column(nullable = false)
    private String profile;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Store> storeList;

    @OneToMany(mappedBy = "reviewer", fetch = FetchType.LAZY)
    private List<Review> reviewList;

    public void updateInfo(String profile, String name) {
        this.profile = profile;
        this.name = name;
    }

}
