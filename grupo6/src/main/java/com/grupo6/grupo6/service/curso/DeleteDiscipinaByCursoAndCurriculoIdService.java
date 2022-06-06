//package com.grupo6.grupo6.service.disciplina;
//
//import com.grupo6.grupo6.domain.Curso;
//import com.grupo6.grupo6.domain.Curriculo;
//import com.grupo6.grupo6.domain.Disciplina;
//import com.grupo6.grupo6.repository.CursoRepository;
//import com.grupo6.grupo6.repository.CurriculoRepository;
//import com.grupo6.grupo6.repository.DisciplinaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class DisciplinaDeleteById {
//    @Autowired
//    private DisciplinaRepository disciplinaRepository;
//
//    @Autowired
//    private CursoRepository cursoRepository;
//
//    @Autowired
//    private CurriculoRepository curriculoRepository;
//
//    @Autowired
//    private DisciplinaResponseMapper disciplinaResponseMapper;
//
//    @Autowired
//    private CursoResponseMapper cursoResponseMapper;
//
//    @Autowired
//    private CurriculoResponseMapper curriculoResponseMapper;
//
//    public void execute(String id_curso, String id_curriculo, String id_disciplina) {
//        Curso cursoExistente = cursoRepository.findById(id_curso);
//        Curso curso = cursoExistente.get();
//
//        Curriculo curriculoExistente = curriculoRepository.findById(id_curriculo);
//        Curriculo curriculo = curriculoExistente.get();
//
//        Optional<Disciplina> disciplinaExistente = disciplinaRepository.getOne(id_disciplina);
//        Disciplina disciplina = disciplinaExistente.get();
//
//        disciplina.setAtiva(false);
//        disciplinaRepository.save(disciplina);
//    }
//}
