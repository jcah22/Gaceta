package com.jcah.models.repository;


import org.springframework.data.repository.CrudRepository;

import com.jcah.models.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {


}
