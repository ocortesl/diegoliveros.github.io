# CPaaS workshop

# Ejercicio 1 CPaaS inBoundXML IVR

# Table of Contents

[Objetivo](#objetivo)

[Introducción a InboundXML](#introducción-a-inboundxml)

[Documentacion AVAYA CPaaS](#documentacion-avaya-cpaas)

[Prerequisitos](#prerequisitos)

[1 Mecanismo de Navegacion por el IVR](#1-mecanismo-de-navegacion-por-el-ivr)

[1.1 Etiquetas <Say> y <Gather> Para instrucciones de voz y recopilacion DTMF](#1.1-etiquetas-<say>-y-<gather>-para-instrucciones-de-voz-y-recopilacion-dtmf)

[1.2 Etiqueta <Redirect> para selección de opciones](#1.2-etiqueta-<redirect>-para-selección-de-opciones)

[1.3 Navegacion del IVR](#1.3-navegacion-del-ivr)

[2 Desarrollo del ejercicio](#2-desarrollo-del-ejercicio)

[2.1 Opcion1: Opciones de texto](#2.1-opcion1:-opciones-de-texto)

[2.1.1 Opcion1: SMS](#2.1.1-opcion1:-sms)

[2.1.2 Opcion2: MMS](#2.1.2-opcion2:-mms)

[2.2 Opcion2: Dejar un mensaje](#2.2-opcion2:-dejar-un-mensaje)

[2.3 Opcion3: Iniciar una conferencia](#2.3-opcion3:-iniciar-una-conferencia)

[2.3.1 opcion1: Conferencia de Seguridad](#2.3.1-opcion1:-conferencia-de-seguridad)

[2.3.2 opcion2: Conferencia de CPaaS](#2.3.2-opcion2:-conferencia-de-cpaas)

[2.4 Opcion4: Escuchar un anuncio](#2.4-opcion4:-escuchar-un-anuncio)

[2.5 Opcion5: Repetir menu](#2.5-opcion5:-repetir-menu)

[2.6 Opcion0: Hablar con un agente](#2.6-opcion0:-hablar-con-un-agente)

[3 publicar aplicación en Avaya CpaaS](#3-publicar-aplicación-en-avaya-cpaas)

[3.1 Iniciar sesion en Avaya CPaaS.](#3.1-iniciar-sesion-en-avaya-cpaas.)

[3.2 Crear aplicación en Avaya CPaaS](#3.2-crear-aplicación-en-avaya-cpaas)

[3.3 Vincular numero telefonico de CPaaS con la aplicación](#3.3-vincular-numero-telefonico-de-cpaas-con-la-aplicación)

[4 Apendice](#4-apendice)

[4.1 Manejo de errores por opcion invalida](#4.1-manejo-de-errores-por-opcion-invalida)

# Objetivo

El objetivo de este ejercicio es realizar un IVR utilizando únicamente la herramienta **InboundXML** de **CPaaS** y un File Server, sin el uso de un servicio de back-end especifico.

Para este propósito haremos uso de algunas etiqutas de InboundXML para lograr la navegación por el flujo del IVR a través de tonos DTMF ingresados por el llamante.

El Flujo a realizar es el siguiente:

![Flujo](images/flujo.jpg)

# Introducción a InboundXML

InboundXML describe cómo Avaya OneCloud CPaaS debe manejar una llamada y un SMS. Básicamente, son instrucciones que le dicen a Avaya OneCloud CPaaS qué hacer cuando recibe una llamada entrante o un SMS. Al recibir una llamada o un SMS, Avaya OneCloud CPaaS sigue las instrucciones de InboundXML, lo que permite a los desarrolladores crear fácilmente aplicaciones de telefonía con la misma función y potencia que se encuentran en los sistemas telefónicos tradicionales.

# Documentacion AVAYA CPaaS

La información relativa a Avaya CPaaS InboundXML así como la documentación respectiva se encuentra en el siguiente link:

[https://docs.avayacloud.com/aspx/inboundxml#overview](https://docs.avayacloud.com/aspx/inboundxml#overview)

# Prerequisitos

Para la elaboración de este ejercicio se debe de cumplir con los siguientes requisitos

-Cuenta con fondos de Avaya CPaaS

-Número telefónico dentro de la plataforma Avaya CPaaS.

-File Server accesible públicamente

# 1 Mecanismo de Navegacion por el IVR

Como se mencionó al principio del documento, este ejemplo solo utilizará **InboundXML** y un File Server, por lo que en los siguientes pasos se describirá el uso de las etiquetas para lograr la navegación por las opciones del IVR

## 1.1 Etiquetas <Say> y <Gather> Para instrucciones de voz y recopilacion DTMF

La etiqueta **<Say>** reproduce audio al llamante utilizando voz-a-texto, dicha etiqueta tiene opciones para cambiar el género de la voz y el lenguaje, a continuación, se muestra un ejemplo:

```xml
<Response>

    <Say voice="man" language="es-us" loop="0">Hola, mi nombre es Miguel</Say>

</Response>
```

La etiqueta **<Gather>** , entre otras cosas, nos permite recopilar entradas DTMF y enviarlas por método GET o POST a la URL indicada en el atributo **action** para posterior procesamiento. En nuestro caso utilizaremos la etiqueta **<Say>** dentro de **<Gather>** para reproducir al llámate las opciones disponibles de nuestro IVR y con los atributos de <Gather> le indicaremos a CPaaS que solo esperamos un digito DTMF y que mande por método GET dicho valor. A continuación, se muestra cómo queda nuestro InboundXML inicial:

Archivo **Main.xml**

```xml
<Response>

  <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/BaseRedirect.xml">

    <Say voice="woman" language="es-us">Presiona UNO para opciones de texto, DOS para dejar un mensaje, TRES para Iniciar una conferencia, CUATRO para escuchar un anuncio, CERO para hablar con un agente, CINCO para repetir el menu.</Say>

  </Gather>

  <!-- Si no se recibe un digito despues de cinco segundos, gather termina y se ejecuta la sig.etiqueta -->

  <Say voice="woman" language="es-us">Hasta luego</Say>

</Response>
```

Atributos de Gather:

- **metod** : Metodo por el cual los DTMF serán enviados, en nuestro caso GET

- **numDigits** : Numero de dígitos que recibirá gather, en nuestro caso 1

- **finishOnKey** : Digito con el cual gather terminara su ejecución y pasara a la siguiente etiqueta

- **action** : URL(fileserver) a la cual CPaaS mandara los parámetros por método GET, en este punto es importante notar que el DTMF será enviado en el parámetro **Digits**

>**Importante:** Notar que la URL del atributo **action** puede retornar un **InboundXML** con mas instrucciones a ejecutar por CPaaS. >Esto es parte fundamental en el desarrollo de este ejercicio.

## 1.2 Etiqueta <Redirect> para selección de opciones

La Etiqueta <Redirect>, como su nombre lo indica, redirige el flujo de la ejecución de la aplicación a la URL indicada y pasando todos los parámetros de la llamada por método GET o POST. Ejemplo

```xml
<Response>

  <Say>You will now be redirected.</Say>

  <Redirect method="POST">http://example.com/rest.xml</Redirect>

<!-- El Say debajo no se ejecutara debido a la redirecicion   -->

<Say>You will never hear this.</Say>

</Response>
```

Debido a que nuestro ejercicio carece de un back-end dedicado para tratar nuestras peticiones GET, vamos a aprovechar la etiqueta **<Redirect>** y el parámetro **Digits** enviado por el <Gather> del punto anterior para seleccionar el InboundXML adecuado. Esto lo logramos concatenando la URL de nuestro file server con el digito enviado por Gather de la siguiente forma

>**Importante:** Los parámetros recibidos por el InboundXML en CPaaS pueden ser referenciados en el xml mismo como sigue
>**{{nombreParametro}}**

<b>http://tufileserver/InboundXML/option</b><b style="color: red;">{{Digits}}</b>**.xml**

Donde <b style="color: red;">{{ Digits }}</b> es el parámetro enviado por Gather y sera reemplazado en tiempo de ejecución por su respectivo valor, asi logramos regresar un xml distinto por cada opción del Gather

<b>http://tufileserver/InboundXML/option</b><b style="color: red;">1</b>**.xml**

<b>http://tufileserver/InboundXML/option</b><b style="color: red;">2</b>**.xml**

<b>http://tufileserver/InboundXML/option</b><b style="color: red;">4</b>**.xml**

<b>http://tufileserver/InboundXML/option</b><b style="color: red;">3</b>**.xml**

**etc…**

Con esta teoría, nuestro siguiente archivo InboundXML (Url action de Gather en Main.xml) queda de la siguiente manera:

Archivo **BaseRedirect.xml**

```xml
<Response>

    <Redirect method="GET">http://tufileserver/InboundXML/option{{Digits}}.xml</Redirect>

</Response>
```

## 1.3 Navegacion del IVR

Si juntamos los conceptos explicados en los puntos 1.1 y 1.2 de esta sección, el mecanismo de navegación por el IVR queda como sigue:

![flujo2](images/flujo2.jpg)

# 2 Desarrollo del ejercicio

En el punto anterior vimos como se manejara la navegación a través del IVR, por lo que ahora se explicaran a detalle cada una de las opciones propuestas en el flujo de nuestro IVR.

## 2.1 Opcion1: Opciones de texto

La opción uno reproduce un submenú al llamante para elegir entre SMS o MMS

Archivo **option1.xml**

```xml
<Response>

  <!-- Submenu de opciones de texto -->

  <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/option1/option1redirect.xml">

    <Say voice="woman" language="es-us">Presiona UNO para SMS, Presiona DOS para MMS</Say>

  </Gather>

</Response>
```

El Inbound XML que recibirá la opción del llamante es:

Archivo **option1/option1redirect.xml**

```xml
<Response>

    <Redirect method="GET">http://tufileserver/InboundXML/option1/option{{Digits}}.xml</Redirect>

</Response>
```

Como se puede apreciar, los InboundXML respectivos a la opción uno, se encuentran dentro de la carpeta **option1**

y se describen a continuación

### 2.1.1 Opcion1: SMS

Esta opción retornara un SMS al llamante con los datos de la llamada

Archivo **option1/option1.xml**

```xml
<Response>

    <Say voice="woman" language="es-us">Recibiras un SMS con los datos de esta llamada.</Say>

    <Sms from="{{To}}" to="{{From}}">ApiVersion: {{ApiVersion}}, CallSid: {{CallSid}}, Direction: {{Direction}}, CallerName:{{CallerName}}</Sms>

    <!-- Fin del flujo -->

    <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/LastRedirect.xml">

      <Say voice="woman" language="es-us">Presiona UNO para volver al menu principal, Presiona DOS para terminar la llamada</Say>

    </Gather>

</Response>
```

### 2.1.2 Opcion2: MMS

Esta opción retornara un MMS al llamante con los datos de la llamada

Archivo **option1/option2.xml**

```xml
<Response>

    <Mms from="{{To}}" to="{{From}}" mediaUrl="http://tufileserver/InboundXML/AVAYA\_CALA.JPG">ApiVersion: {{ApiVersion}}, CallSid: {{CallSid}}, Direction: {{Direction}}, CallerName:{{CallerName}}</Mms>

    <!-- Fin del flujo -->

    <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/LastRedirect.xml">

      <Say voice="woman" language="es-us">Presiona UNO para volver al menu principal, Presiona DOS para terminar la llamada</Say>

    </Gather>

</Response>
```

## 2.2 Opcion2: Dejar un mensaje

Esta opción graba un mensaje del llamante y despues lo reproduce:

Archivo **option2.xml**

```xml
<Response>

    <!-- Opcion dos, grabar mensaje y reproducirlo -->

    <Say voice="woman" language="es-us">Graba tu mensaje y al finalizar presiona numeral.</Say>

    <Record background="false" playBeep="true" finishOnKey="#" action="http://webhookr.com/cpaas-inboundxml-recording-action-example" method="POST"/>

    <Say voice="woman" language="es-us">Su mensaje es:</Say>

    <PlayLastRecording/>

    <!-- Fin del flujo -->

    <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/LastRedirect.xml">

      <Say voice="woman" language="es-us">Presiona UNO para volver al menu principal, Presiona DOS para terminar la llamada</Say>

    </Gather>

</Response>
```

Como nota, a la URL del atributo **action** de la etiqueta <Record> se enviara por método POST la grabación así como información relativa a la misma.

## 2.3 Opcion3: Iniciar una conferencia

La opción uno reproduce un submenú al llamante para elegir entre conferencia de CPaaS o conferencia de seguridad:

Archivo **option3.xml**

```xml
<Response>

  <!-- Submenu de opciones de texto -->

  <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/option3/option3redirect.xml">

    <Say voice="woman" language="es-us">Presiona UNO para conferencia de seguridad, Presiona DOS para conferencia de si paz</Say>

  </Gather>

</Response>
```

El Inbound XML que recibirá la opción del llamante es:

Archivo **option3/option3redirect.xml**

```xml
<Response>

    <Redirect method="GET">http://tufileserver/InboundXML/option3/option{{Digits}}.xml</Redirect>

</Response>
```

Como se puede apreciar, los InboundXML respectivos a la opción uno, se encuentran dentro de la carpeta **option3**

y se describen a continuación

### 2.3.1 opcion1: Conferencia de Seguridad

Crea o ingresa a la conferencia de Seguridad con un máximo de 5 participantes. La conferencia termina al presionar el digito **\***

Archivo **option3/option1.xml**

```xml
<Response>

  <Say voice="woman" language="es-us">La conferencia de seguridad iniciara despues del tono</Say>

  <Dial>

      <Conference startConferenceOnEnter="true" record="true" beep="true" hangupOnStar="true" maxParticipants="5" recordCallbackUrl="http://webhookr.com/cpaas-inboundxml-recording-action-example">SecurityConference</Conference>

  </Dial>

  <!-- Fin del flujo -->

  <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/LastRedirect.xml">

    <Say voice="woman" language="es-us">Presiona UNO para volver al menu principal, Presiona DOS para terminar la llamada</Say>

  </Gather>

</Response>
```

### 2.3.2 opcion2: Conferencia de CPaaS

Crea o ingresa a la conferencia de CPaaS con un máximo de 5 participantes. La conferencia termina al presionar el digito **\***

Archivo **option3/option2.xml**

```xml
<Response>

  <Say voice="woman" language="es-us">La conferencia de si paz iniciara despues del tono</Say>

  <Dial>

      <Conference startConferenceOnEnter="true" record="true" beep="true" hangupOnStar="true" maxParticipants="5" recordCallbackUrl="http://webhookr.com/cpaas-inboundxml-recording-action-example">CPaaSConference</Conference>

  </Dial>

  <!-- Fin del flujo -->

  <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/LastRedirect.xml">

    <Say voice="woman" language="es-us">Presiona UNO para volver al menu principal, Presiona DOS para terminar la llamada</Say>

  </Gather>

</Response>
```

## 2.4 Opcion4: Escuchar un anuncio

Esta opción reproduce un audio al llamante usando la etiqueta **<Play>**. Los formatos permitidos son mp3, wav, gsm, aif.

Archivo **option4.xml**

```xml
<Response>

    <!-- Opcion cuatro, escuchar anuncio -->

    <Play>https://www.sinj.com/sounds/mp3s/Classical/Bach%20-%20French%20Suite%202,%204%20-%20Air.mp3</Play>

    <!-- Fin del flujo -->

    <Gather method="GET" numDigits="1" finishOnKey="#" action="http://tufileserver/InboundXML/LastRedirect.xml">

      <Say voice="woman" language="es-us">Presiona UNO para volver al menu principal, Presiona DOS para terminar la llamada</Say>

    </Gather>

</Response>
```

## 2.5 Opcion5: Repetir menu

Esta opción repite el menú inicial, lo cual se logra con la etiqueta **<Redirect>** hacia nuestro archivo **main.xml**

Archivo **option5.xml**

```xml
<Response>

    <!-- Opcion Cinco, regresar al menu principal -->

    <Redirect method="GET">https://tufileserver/InboundXML/main.xml </Redirect>

</Response>
```

## 2.6 Opcion0: Hablar con un agente

Esta opción redirecciona la llamada a el número indicado como parámetro, también inicia la grabación de dicha llamada

Archivo **option0.xml**

```xml
<Response>

    <!-- Opcion cero, hablar con un agente -->

    <Say voice="woman" language="es-us">Su llamada esta siendo transferida y podra ser grabada</Say>

    <Record background="true" playBeep="true" finishOnKey="#"/>

    <Dial>
      <Sip>2867@186.28.237.130</Sip>
    </Dial>

</Response>
```

# 3 publicar aplicación en Avaya CpaaS

Ahora publicaremos la aplicación en Avaya CPaaS configurando nuestro InboundXML inicial ( **main.xml** ) en la **Voice Request Url** de nuestro número en CPaaS. Los pasos se describen a continuación:

## 3.1 Iniciar sesion en Avaya CPaaS.

Iniciamos sesión en nuestra cuanta de Avaya CPaaS en el siguiente link: [https://cloud.zang.io/](https://cloud.zang.io/) , debemos contar con un numero telefónico en nuestra cuenta para poder continuar, si no contamos con uno hay que comprarlo en la siguiente liga: [https://cloud.zang.io/numbers/buy/](https://cloud.zang.io/numbers/buy/)

## 3.2 Crear aplicación en Avaya CPaaS

Accedemos a la opción de **Aplicaciones** dando click en **Numbers > Manage Applications**

![cpaas3.2.1](images/cpaas3.2.1.jpg)

Despues damos click en Add Application:

![cpaas3.2.2](images/cpaas3.2.2.jpg)

Asignamos un nombre amigable a nuestra aplicación

![cpaas3.2.3](images/cpaas3.2.3.jpg)

Damos click en la pestaña **Voice** y configuramos la URL de nuestro **InboundXML** inicial.

![cpaas3.2.4](images/cpaas3.2.4.jpg)

Ahora damos click en **Create** para guaradar nuestra aplicación.

![cpaas3.2.5](images/cpaas3.2.5.jpg)

## 3.3 Vincular numero telefonico de CPaaS con la aplicación

Ahora vincularemos la aplicación con nuestro número telefónico de CPaaS. Para ello accedemos a la configuración de nuestro número telefónico dando click en **Numbers** > **Manage Numbers.**

![cpaas3.2.6](images/cpaas3.2.6.jpg)

Damos click sobre el numero al cual vincularemos la aplicación

![cpaas3.2.7](images/cpaas3.2.7.jpg)

Activamos el checkbox **Use application voice settings** y elegimos la aplicación que creamos en el paso 3.2

![cpaas3.2.8](images/cpaas3.2.8.jpg)

Damos click en **Save** y nuestra aplicación quedara vinculada a nuestro número de CPaaS.

![cpaas3.2.9](images/cpaas3.2.9.jpg)

# 4 Apendice

## 4.1 Manejo de errores por opcion invalida

Al desarrollar este ejercicio haciendo uso de las etiquetas <Gather> y <Redirect> para la navegación a través del IVR, podemos notar que pueden ocurrir errores debidos las opciones inexistentes en nuestro flujo, por ejemplo, de acuerdo a nuestro diagrama principal, solo tenemos opciones del 1 al 5 en el primer menu, y si el usuario presiona el digito 6, <Redirect> solicitara el InboundXML **http://tufileserver/InboundXML/option6.xml** el cual no existe en nuestro File Server, por lo tanto generara un error en la aplicación.

 Para manejar estos errores, se propone "**rellenar**" las opciones invalidas en el primer menu

http://tufileserver/InboundXML/option6.xml
http://tufileserver/InboundXML/option7.xml
http://tufileserver/InboundXML/option8.xml
http://tufileserver/InboundXML/option9.xml

con el mismo contenido siguiente:

```xml
<Response>

    <!-- Opcion invalida -->

    <Say voice="woman" language="es-us">Opcion invalida</Say>

    <!-- Retornamos al menu principal -->

    <Redirect method="GET">http://tufileserver/InboundXML/main.xml</Redirect>

</Response>
```

Esto mismo debe hacerse con las opciones invalidas de los submenús.