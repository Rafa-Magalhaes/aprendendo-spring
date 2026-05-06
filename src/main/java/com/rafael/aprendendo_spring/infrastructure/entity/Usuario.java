package com.rafael.aprendendo_spring.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "usuario")

public class Usuario implements UserDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome", length = 100, nullable = false)
    private String nome;

    @Column (name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column (name = "senha", nullable = false)
    private String senha;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id" )
    private List<Enderecos> endereco;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "usuario_id", referencedColumnName = "id")
    private List<Telefones> telefone;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
