package com.mercadolibreprueba.mercadomobile.controller;

import com.mercadolibreprueba.mercadomobile.model.ProductModel;
import com.mercadolibreprueba.mercadomobile.model.QueryProductResultModel;

import java.util.ArrayList;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class RXProductBus {

        private static final BehaviorSubject<ArrayList<ProductModel>> behaviourSubject
                = BehaviorSubject.create();

        public static BehaviorSubject<ArrayList<ProductModel>> getBehaviourSubject() {
            return behaviourSubject;
        }

}
