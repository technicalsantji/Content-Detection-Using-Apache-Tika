package com.text.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.text.model.Template;
public interface TemplateRepository extends JpaRepository<Template, Long> {

//	public final static String SQL_Query="delete from template where tems_id=:id returning tems_id";
//	
//	@Query(value=SQL_Query,nativeQuery =true)
//	public Long deleteBytemid(@Param("id") Long id);
}
