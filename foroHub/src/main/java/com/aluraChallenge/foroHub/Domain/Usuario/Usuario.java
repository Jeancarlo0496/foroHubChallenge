package com.aluraChallenge.foroHub.Domain.Usuario;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Table(name = "usuario")
@Entity(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Setter
    @Column(name = "nombre")
    private String nombre;
    @Setter
    @Column(name = "email")
    private String email;
    @Setter
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "perfil")
    private String perfil;

    public Usuario(DatosRegistroUsuario datos) {
        this.nombre = datos.nombre();
        this.email = datos.email();
        this.contraseña = datos.contraseña();
        this.perfil = datos.perfil();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contraseña;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {return true;}

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {return true;}

}