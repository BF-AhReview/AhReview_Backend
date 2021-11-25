package com.bulgogifriedrice.backend.domain.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Column(nullable = false)
    private boolean isStoreOwner;

    public void updateInfo(String profile, String name) {
        this.profile = profile;
        this.name = name;
    }

}
