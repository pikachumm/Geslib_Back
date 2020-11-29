package com.geslib.back.servicio;

public class UsuarioService{
	
}
/*
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.lang.String;
import com.geslib.back.Temporals.RegistrarUsuario;
import com.geslib.back.modelo.Rol;
import com.geslib.back.modelo.Usuario;
import com.geslib.back.repositorio.UsuarioRepository;



@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    //private BCryptPasswordEncoder passwordEncoder;

    public Usuario findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario save(RegistrarUsuario registration){
        Usuario usuario = new Usuario();
       // usuario.set
        //user.setFirstName(registration.getFirstName());
        //user.setLastName(registration.getLastName());
        //user.setEmail(registration.getEmail());
        //user.setPassword(passwordEncoder.encode(registration.getPassword()));
        //user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(),
                usuario.getPassword(),
                mapRolesToAuthorities(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities (Collection<Rol> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}*/