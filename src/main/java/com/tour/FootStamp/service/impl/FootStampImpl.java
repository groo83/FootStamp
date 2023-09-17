package com.tour.FootStamp.service.impl;

import com.tour.FootStamp.dto.FootStampDto;
import com.tour.FootStamp.entity.FootStamp;
import com.tour.FootStamp.repository.FootStampRepository;
import com.tour.FootStamp.service.FootStampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class FootStampImpl implements FootStampService {
    private final FootStampRepository footStampRepository;

    @Autowired
    public FootStampImpl(FootStampRepository footStampRepository) {
        this.footStampRepository = footStampRepository;
    }

    @Override
    public List<FootStampDto> register(FootStampDto footStampDto) {
        //return footStampRepository.save(footStampDto);

        // TODO REMOVE
        List<FootStampDto> list = new List<FootStampDto>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<FootStampDto> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(FootStampDto footStampDto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends FootStampDto> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends FootStampDto> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public FootStampDto get(int index) {
                return null;
            }

            @Override
            public FootStampDto set(int index, FootStampDto element) {
                return null;
            }

            @Override
            public void add(int index, FootStampDto element) {

            }

            @Override
            public FootStampDto remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<FootStampDto> listIterator() {
                return null;
            }

            @Override
            public ListIterator<FootStampDto> listIterator(int index) {
                return null;
            }

            @Override
            public List<FootStampDto> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        return list;
    }

}
