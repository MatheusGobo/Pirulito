package br.com.unipar.EstagioSerch.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sys_user")
@SequenceGenerator(name = "user", sequenceName = "user_sequence_id", allocationSize = 1)
public class User {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(cd_user, user.cd_user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cd_user);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    @Column(name = "cd_user")
    private Long cd_user;

    @Column(name = "username", length = 128, nullable = false)
    private String username;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "categoria", length = 128, nullable = false)
    private Categoria categoria;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getCd_user() {
        return cd_user;
    }

    public void setCd_user(Long cd_user) {
        this.cd_user = cd_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
