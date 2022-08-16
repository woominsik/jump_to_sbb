package com.ll.exam.sbb.question;

import com.ll.exam.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.chrono.MinguoDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(int id) {
        Optional<Question> oq = questionRepository.findById(id);

        if ( oq.isPresent() ) {
            return oq.get();
        }

        throw new DataNotFoundException("question not found");
    }
}