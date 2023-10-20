package com.orosoft.userchache.service;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.orosoft.grpc.history.CategoriesHistoryData;
import com.orosoft.grpc.history.HistoryCachingServiceGrpc;
import com.orosoft.grpc.history.ProductsHistoryData;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HistoryCachingService extends HistoryCachingServiceGrpc.HistoryCachingServiceImplBase{

	Config config = new Config();
	HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
	IMap<String, ProductsHistoryData> productsHistoryCache = hazelcastInstance.getMap("myProductsHistory");
	IMap<String, CategoriesHistoryData> categoriesHistoryCache= hazelcastInstance.getMap("myCategoriesHistory");
	IMap<String, Integer> historyCounter = hazelcastInstance.getMap("HistoryCounter");
}
