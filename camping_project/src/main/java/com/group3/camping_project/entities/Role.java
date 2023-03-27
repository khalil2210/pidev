package com.group3.camping_project.entities;

import com.group3.camping_project.entities.enums.RoleName;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
        @Id
        @GeneratedValue(strategy =
                GenerationType.AUTO)
        private int id;
        @Enumerated(EnumType.STRING)
        private RoleName role;

        @Override
        public String toString() {
                return "Role{" +
                        "id=" + id +
                        ", role=" + role +
                        '}';
        }
}
