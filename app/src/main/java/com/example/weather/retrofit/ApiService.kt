package com.example.buyok_jetpack.retrofit


import com.example.weather.models.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {

//    @Headers("Accept: application/json")
//    @FormUrlEncoded
//    @POST("/v1/auth/request-otp")
//    suspend fun requestOTP(@Field("mobile") mobile: String): Response<LoginRequestResponse>
//
//    @Headers("Accept: application/json")
//    @FormUrlEncoded
//    @POST("/v1/auth/verify-otp")
//    suspend fun verifyOTP(
//        @Field("mobile") mobile: String,
//        @Field("otp") otp: String
//    ): Response<VerifyOTPResponse>

    @Headers("Accept: application/json")
    @GET("weather/")
    suspend fun weatherApiWithLatLong(
        @Query("lat") lat: String = "19.2172713",
        @Query("lon") lon: String = "72.8241238",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "81f655c60eb0a2e3e170a2c6ce091ed8"
    ): Response<WeatherResponse>

    @Headers("Accept: application/json")
    @GET("weather/")
    suspend fun weatherApiWithCityName(
        @Query("q") q: String = "Mumbai",
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = "81f655c60eb0a2e3e170a2c6ce091ed8"
    ): Response<WeatherResponse>

//
//    @Headers("Accept: application/json")
//    @FormUrlEncoded
//    @POST("/v1/user/update-userinfo")
//    suspend fun updateUserNameEmail(
//        @Field("fullname") fullname: String,
//        @Field("email") email: String
//    ): Response<UpdateUserInfoResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/categories/follow/bulk")
//    suspend fun addCategories(
//        @Body topics: String
//    ): Response<UpdateUserInfoResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/enquiries/become-a-seller")
//    suspend fun becomeASeller(
//        @Body requestBody: BecomeASellerRequestBody
//    ): Response<BecomeASellerResponse>
//
//
//    @Headers("Accept: application/json")
//    @GET("/v1/enquiries/become-a-seller/status")
//    suspend fun getBecomeSellerStatus(
//    ): Response<BecomeASellerStatusResponse>
//
//
//    @Headers("Accept: application/json")
//    @GET("/v1/store/mystores")
//    suspend fun callFetchStoreApi(
//    ): Response<FetchStoreResponse>
//
//    @Headers("Accept: application/json")
//    @GET("/v1/store/{store_id}/task-status")
//    suspend fun callFetchStoreTaskStatusApi(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<FetchStoreTaskStatusResponse>
//
//    @Headers("Accept: application/json")
//    @GET("/v1/analytics/{store_id}/quick-view")
//    suspend fun fetchStoreQuickViewApi(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<StoreQuickView>
//
//
//    @Headers("Accept: application/json")
//    @GET("/v1/store/{store_id}/profile")
//    suspend fun callFetchStoreProfileApi(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<FetchStoreProfileResponse>
//
//
//    @Headers("Accept: application/json")
//    @GET("/v1/categories/store-categories/{store_id}")
//    suspend fun callFetchCategoryWithFollowingApi(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<FetchCategoryWithFollowingResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @PATCH("/v1/store/{store_id}/update-profile")
//    suspend fun callUpdateProfileApi(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: String
//    ): Response<UpdateProfileResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @PATCH("/v1/store/{store_id}/update-categories")
//    suspend fun callUpdateStoreCategoryApi(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: String
//    ): Response<UpdateProfileResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/store/{store_id}/payments")
//    suspend fun callFetchBankDetailsApi(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<FetchPaymentDetailsResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/store/{store_id}/payments")
//    suspend fun callAddBankDetailsApi(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: AddPaymentRequestBody
//    ): Response<AddPaymentResponse>
//
//
//    @Headers("Accept: application/json")
//    @GET("/v1/store/{store_id}/pickups")
//    suspend fun callFetchStoreAvailablePickupAddressApi(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<StoreAvailablePickupAddressResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/store/{store_id}/delivery-pricing")
//    suspend fun callFetchStoreDeliveryPricingApi(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<FetchDeliveryPricingResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/store/{store_id}/delivery-pricing")
//    suspend fun callAddUpdateDeliveryPricingApi(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: String
//    ): Response<FetchDeliveryPricingResponse>
//
//
//    // seller order
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/orders/{store_id}/list/")
//    suspend fun callListAllOrders(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<ListAllOrdersResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/orders/{store_id}/list/?page=1")
//    suspend fun callListAllOrdersWithFilter(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Query("filter") filter: String
//    ): Response<ListAllOrdersResponse>
//
//
//    @Headers("Accept: application/json")
//    @GET("/v1/auth/logout")
//    suspend fun logout(
//    ): Response<LogoutResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/{store_id}/inventory/?page=1")
//    suspend fun fetchInventoryList(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<InventoryListResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/{store_id}/inventory/")
//    suspend fun fetchInventorySearchList(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Query("page") page: String,
//        @Query("search") search: String
//    ): Response<InventoryListResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/products/{store_id}/inventory")
//    suspend fun updateInventory(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: String
//    ): Response<UpdateInventoryResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/{store_id}/list/all")
//    suspend fun fetchAllProductList(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<SellerAllProductListResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/{store_id}/list/instock")
//    suspend fun fetchInStockProductList(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<SellerAllProductListResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/{store_id}/list/outofstock")
//    suspend fun fetchOutOfStockProductList(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<SellerAllProductListResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/reels/{store_id}/list")
//    suspend fun fetchReelsList(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<ReelsListResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/products/{store_id}/create")
//    suspend fun createNewProduct(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: String
//    ): Response<CreateNewProductResponse>
//
//
//    ///////
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/{store_id}/view-item/{product_id}")
//    suspend fun viewAProduct(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "product_id", encoded = true) product_id: String,
//    ): Response<ViewAProductResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/products/{store_id}/update")
//    suspend fun updateProductAndVariants(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: UpdateProductAndVariantsRequestBody
//    ): Response<UpdateProductAndVariantsResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/products/generate-variations")
//    suspend fun generateVariations(
//        @Body requestBody: GenerateVariationsRequestBody
//    ): Response<GenerateVariationResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/tax-list")
//    suspend fun taxList(
//    ): Response<TaxListResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/gender-list")
//    suspend fun genderList(
//    ): Response<GenderListResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/products/origin-of-country")
//    suspend fun originOfCountryList(
//    ): Response<OriginOfCountryListResponse>
//
//
//    @Multipart
//    @POST("/v1/uploads/images")
//    suspend fun uploadImage(
//        @Part file: MultipartBody.Part
//    ): Response<UploadImageResponse>
//
//
//
//    /**
//     * Orders
//     * */
//    @Headers("Accept: application/json")
//    @GET("/v1/orders/{store_id}/view/{order_id}")
//    suspend fun viewAOrder(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "order_id", encoded = true) order_id: String
//    ): Response<ViewAOrderResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/orders/{store_id}/custom-shipping/{order_id}")
//    suspend fun addShippingDetails(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "order_id", encoded = true) order_id: String,
//        @Body requestBody: String
//    ): Response<AddShippingDetailsResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/orders/{store_id}/action/delivered/{order_id}")
//    suspend fun markedAsDelivered(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "order_id", encoded = true) order_id: String
//    ): Response<MarkedAsDeliveredResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/orders/{store_id}/action/rto/{order_id}")
//    suspend fun markedAsRTO(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "order_id", encoded = true) order_id: String,
//        @Body requestBody: String
//    ): Response<MarkedAsDeliveredResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/orders/{store_id}/action/accept/{order_id}")
//    suspend fun acceptOrder(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "order_id", encoded = true) order_id: String
//    ): Response<MarkedAsDeliveredResponse>
//
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/orders/{store_id}/action/reject/{order_id}")
//    suspend fun rejectOrder(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "order_id", encoded = true) order_id: String
//    ): Response<MarkedAsDeliveredResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/orders/{store_id}/list/")
//    suspend fun orderListBySearch(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Query("page") page: String,
//        @Query("search") search: String
//    ): Response<ListAllOrdersResponse>
//
//
//
//
//
//    /**
//    * reels
//    * */
//
//    // upload thumbnail
//    @Multipart
//    @POST("/v1/uploads/reels/thumbnail/{store_id}")
//    suspend fun uploadThumbnail(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Part file: MultipartBody.Part
//    ): Response<UploadImageResponse>
//
//
//    // create reel
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @POST("/v1/reels/{store_id}/update")
//    suspend fun createReel(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Body requestBody: CreateReelRequest
//    ): Response<CreateReelResponse>
//
//
//    @Multipart
//    @POST("/v1/uploads/video-upload/{store_id}/{store_reel_id}")
//    suspend fun uploadReel(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "store_reel_id", encoded = true) store_reel_id: String,
//        @Part file: MultipartBody.Part
//    ): Response<UploadReelResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/reels/{store_id}/private/{store_reel_id}")
//    suspend fun viewAReel(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "store_reel_id", encoded = true) store_reel_id: String,
//    ): Response<ViewAReelResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @DELETE("/v1/reels/{store_id}/{store_reel_id}")
//    suspend fun deleteAReel(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "store_reel_id", encoded = true) store_reel_id: String,
//    ): Response<DeleteReelResponse>
//
//
//
//
//    /**
//     *
//     * Payouts api
//     *
//     * */
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/payouts/{store_id}/pending")
//
//    suspend fun pendingPayouts(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<PendingPayoutsResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/payouts/{store_id}/completed")
//    suspend fun completedPayouts(
//        @Path(value = "store_id", encoded = true) store_id: String
//    ): Response<CompletedPayoutsResponse>
//
//    @Headers("Accept: application/json", "Content-Type: application/json")
//    @GET("/v1/payouts/{store_id}/transaction/{id}")
//    suspend fun detailsPayouts(
//        @Path(value = "store_id", encoded = true) store_id: String,
//        @Path(value = "id", encoded = true) id: String
//    ): Response<DetailsPayoutsResponse>
//
//
//    /**
//     * feed
//     * */
//
//    @Headers("Accept: application/json")
//    @GET("/v1/reels/feed/")
//    suspend fun reelsFeedList(
//    ): Response<ReelsFeedResponse>


}
