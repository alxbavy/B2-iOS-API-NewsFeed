package murraco.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import murraco.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

  boolean existsByEmail(String email);

  AppUser findByEmail(String email);

  @Transactional
  void deleteByEmail(String email);

}
