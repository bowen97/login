package com.dell.login.mapper;



import org.apache.ibatis.annotations.*;
import com.dell.login.entity.userEntity;

import java.util.List;


public interface userMapper {
    @Select("select * from users where binary userName=#{userName} and binary userPassword=#{userPassword};")
    @Results({
            @Result(property = "userName", column = "userName"),
            @Result(property = "userPassword", column = "userPassword")
    })
    userEntity getAll(@Param("userName")String userName, @Param("userPassword")String userPassword);

    @Insert("INSERT INTO articals (author,content,title,traffic) VALUES(#{author},#{content},#{title},#{traffic})")
    void insert(userEntity user);

    @Update("update userlogin.articals set content = #{content} where title = #{title} and author = #{author}")
    void update(userEntity user);

    @Delete("delete from userlogin.articals where author = #{author} and title = #{title}")
    void delete(userEntity user);

    @Select("select count(1) from userlogin.articals")
    @Results({
            @Result(property = "count(1)", column = "count(1)")
    })
    int count();

    @Select("select * from userlogin.articals limit #{start},10")
    @Results({
            @Result(property = "author", column = "author"),
            @Result(property = "title", column = "title"),
            @Result(property = "id", column = "id")
    })
    List<userEntity> getBlog(int start);

    @Select("select content from articals where id=#{id}")
    @Results({
            @Result(property = "content",column = "content")
    })
    String getContent(int id);
}
