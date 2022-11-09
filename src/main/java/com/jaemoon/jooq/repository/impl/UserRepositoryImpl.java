/*
 * SteVe - SteckdosenVerwaltung - https://github.com/steve-community/steve
 * Copyright (C) 2013-2019 RWTH Aachen University - Information Systems - Intelligent Distributed Systems Group (IDSG).
 * All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.jaemoon.jooq.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.JoinType;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.jooq.SelectQuery;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaemoon.jooq.repository.UserRepository;
import com.jaemoon.jooq.repository.dto.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Sevket Goekay <sevketgokay@gmail.com>
 * @since 25.11.2015
 */
@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired private DSLContext ctx;
    @Autowired private AddressRepository addressRepository;

    @Override
    public List<User> getList() {
        return ctx.select()
        		.from(USER);
    }

    public User getDetail(int userNo) {
        return ctx.select()
                  .from(USER)
                  .where(USER.USER_NO.eq(userNo));
    }

    public  void add(User form) {
        int count = ctx.insertInto(USER)
                       .set(USER.FIRST_NAME, form.getFirstName())
                       .set(USER.LAST_NAME, form.getLastName())
                       .set(USER.BIRTH_DAY, form.getBirthDay())
                       .set(USER.SEX, form.getSex().getDatabaseValue())
                       .set(USER.PHONE, form.getPhone())
                       .set(USER.E_MAIL, form.getEMail())
                       .set(USER.NOTE, form.getNote())
                       .set(USER.ADDRESS_PK, addressPk)
                       .set(USER.OCPP_TAG_PK, selectOcppTagPk(form.getOcppIdTag()))
                       .execute();
        if (count != 1) {
            throw new SteveException("Failed to insert the user");
        }
    }

    public void update(User form) {
        ctx.update(USER)
           .set(USER.FIRST_NAME, form.getFirstName())
           .set(USER.LAST_NAME, form.getLastName())
           .set(USER.BIRTH_DAY, form.getBirthDay())
           .set(USER.SEX, form.getSex().getDatabaseValue())
           .set(USER.PHONE, form.getPhone())
           .set(USER.E_MAIL, form.getEMail())
           .set(USER.NOTE, form.getNote())
           .set(USER.ADDRESS_PK, addressPk)
           .set(USER.OCPP_TAG_PK, selectOcppTagPk(form.getOcppIdTag()))
           .where(USER.USER_PK.eq(form.getUserPk()))
           .execute();
    }

    public void delete(int userNo) {
        ctx.delete(USER)
           .where(USER.USER_NO.equal(userNo))
           .execute();
    }
}
