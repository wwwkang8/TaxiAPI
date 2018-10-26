package com.drama.taxi.repository;

import com.drama.taxi.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByOrderByCreateDateDesc();

    Booking findBookingById(Long id);

}
