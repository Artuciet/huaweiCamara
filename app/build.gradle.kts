import com.android.build.api.dsl.ApplicationBuildType

//Creando el debuggable como "property extension".
private var Any.debuggable: Any
    get() = Unit
    set(value) {true}

//Creacion del v2SigningEnabeled como "Extension property"
private var Any.v2SigningEnebeled: Unit
    get() {}
    set(value) {true}

//Creacion del v1SigningEnabeled como "Extension property"
private var Any.v1SigningEnabeled: Unit
    get() {}
    set(value) {true}

//Esto se creo mediante colocar o crear el "storeFile como ANY y asi tener mayor variedad de opciones.
private val Any.storeFile: Any
    get() {
        TODO("Not yet implemented")
    }

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.hselfiecamera1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hselfiecamera1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    signingConfigs{
        release {
            storeFile file ("selfiecamera")
            keyAlias ("selfiecamera")
            keyPassword ("huawei")
            storePassword ("huawei")
            //Aca se emplearon los ";" para separar las liseas puesto que entraban en conflicto a cada rato.
            v1SigningEnabeled; true
            v2SigningEnebeled; true
        }
    }

    buildTypes {
        release {
            signingConfigs.release {  }//acabo de masacrar el "signingConfigs signingConfigs.release"
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            debug {
                signingConfigs.release {  }//acabo de masacrar el "signingConfigs signingConfigs.release"
                debuggable = true
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //no es compatible la linea de abajo
    //implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //no son compatibles. la linea de abajo
    //implementation("com.android.support:support-v13:28.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //ACA EMPIEZAN A PEGARSE LAS LIBRERIAS DADAS EN LOS COMENTARIOS DE PLATZI QUIZAS LA MAYORIRA ESTEN YA DESACTUALIZADAS, REVISAR MEJOR CUANDO NO SE TEGA TANTO SUEÑO)
    //Account Kit
    implementation("com.huawei.hms:hwid:6.9.0.301")
    //Push Kit
    implementation("com.huawei.hms:push:4.0.4.300")
    // Import the base SDK.
    implementation("com.huawei.hms:ml-computer-vision-face:2.0.1.300")
    // Import the contour and key point detection model package.
    implementation("com.huawei.hms:ml-computer-vision-face-shape-point-model:2.0.1.300")
    // Import the facial expression detection model package.
    implementation("com.huawei.hms:ml-computer-vision-face-emotion-model:2.0.1.300")
    // Import the facial feature detection model package.
    implementation("com.huawei.hms:ml-computer-vision-face-feature-model:2.0.1.300")

    //Aquello que deberia estar en el build de HSelfieCamera y no en app.
    //Account Kit version SDK 27/05/2023
    implementation("com.huawei.hms:hwid:6.9.0.301")
    implementation("com.huawei.agconnect:agcp:5.0.0.300") //investigar luego la falla de esto.
    //Push Kit version SDK 14/06/2023
    //implementation("com.huawei.hms.push.6.11.0.300")
    //ML Kit or machine learning kit version SDK (siendo sincero hay un reverguero con las actualizaciones de sus librerias, asique tome los de HiAI que es la IA de huawei)
    //implementation("com.huawei.hiai.vision.visionkit.common.Frame")//Load the Frame class.
    //implementation("com.huawei.hiai.vision.visionkit.face.detector.Face")//Load the face detection result class.
    //implementation("com.huawei.hiai.vision.visionkit.common.BoundingBox")
    //implementation("com.huawei.hiai.vision.face.detector.FaceDetector")//Load the face detector class.
    //implementation("com.huawei.hiai.vision.common.VisionBase")//Load the static class for connecting to the service.
    //implementation("com.huawei.hiai.vision.common.ConnectionCallback")//Load the callback for connecting to the service.
}
//Aca tambien se  creo esta seccion como "ANY y asi tener algo que no entre en conflicto, pero revisar o chequear luego la parte del release en azul con la parte de buildTypes
infix fun Any.file(s: String) {

}
//Creacion de el "release" como "ANY"
fun Any.release(action: ApplicationBuildType.() -> Unit) {

}
//Creando el "keyAlias" como "ANY"
fun Any.keyAlias(s: String) {

}
//Creacion del keyPassword como ANY.
fun Any.keyPassword(s: String) {

}
//Creacion del storePassword como ANY.
fun Any.storePassword(s: String) {

}
