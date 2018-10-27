package com.drama.taxi.repository;

import com.drama.taxi.domain.Booking;
import com.drama.taxi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByOrderByCreateDateDesc();

    Booking findBookingById(Long id);

    //@Query("select b from Booking b, User u where b.user_id=u.id and b.user_id=:id")
    @Query("select b from Booking b inner join b.user u where u.id = :id")
    List<Booking> findPassengerBookingList(@Param("id")Long id);

}
