package com.anacecilia.backend.repository;

import com.anacecilia.backend.entity.Curso;
import com.anacecilia.backend.entity.Inscripcion;
import com.anacecilia.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByUsuario(Usuario usuario);
    Optional<Inscripcion> findByUsuarioAndCurso(Usuario usuario, Curso curso);
    boolean existsByUsuarioAndCurso(Usuario usuario, Curso curso);
}
