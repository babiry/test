package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dto.Sentence;

@Mapper
public interface SentenceMapper {

       @Select("SELECT word,answer FROM sentence")
        List<Sentence> selectAll();
}
