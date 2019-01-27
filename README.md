# TemplateApp
Template for android application

It is a java based application, it uses Retrofit for networking to retrieve some data from https://swapi.co/ api.

libraries used:


    //Navigation component
    implementation 'android.arch.navigation:navigation-fragment:1.0.0-alpha11'
    
    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.4.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.11.0'
    implementation 'com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0'

    // RxJava
    implementation 'io.reactivex.rxjava2:rxjava:2.2.0'
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'

    //RecyclerView
    implementation 'androidx.recyclerview:recyclerview:1.0.0'

    //Preferences
    implementation 'androidx.preference:preference:1.0.0'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.8.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'
