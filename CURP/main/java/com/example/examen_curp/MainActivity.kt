package com.example.examen_curp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Spinner Sexo
        var sexo = arrayOf("Mujer", "Hombre")
        val spinnerSexo = findViewById<Spinner>(R.id.spinner_Sexo)
        var Spinner_Sexo = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sexo)
        spinnerSexo.adapter = Spinner_Sexo

        //Spinner Estado
        var estados = arrayOf("AS-Aguascalientes", "BC-Baja California", "BS-Baja California Sur",
                "CC-Campeche", "CS-Chiapas", "CH-Chihuahua", "DF-Ciudad de México", "CL-Coahuila",
                "CM-Colima", "DG-Durango", "GT-Guanajuato", "GR-Guerrero", "HG-Hidalgo", "JC-Jalisco",
                "MC-México", "MN-Michoacán","MS-Morelos","NT-Nayarit","NL-Nuevo León","OC-Oaxaca",
                "PL-Puebla","QO-Querétaro","QR-Quintana Roo","SP-San Luis Potosí","SL-Sinaloa",
                "SR-Sonora","TC-Tabasco","TS-Tamaulipas","TL-Tlaxcala","VZ-Veracruz","YN-Yucatan","ZS-Zacatecas")

        val spinnerEstado = findViewById<Spinner>(R.id.spinner_Estado)
        var Spinner_Estados = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, estados)
        spinnerEstado.adapter = Spinner_Estados

        //Spinner Dia
        val dia = arrayOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31")

        val spinnerDia = findViewById<Spinner>(R.id.spinner_Dia)
        var Spinner_Dia = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dia)
        spinnerDia.adapter = Spinner_Dia

        //Spinner Mes
        val mes = arrayOf("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")

        val spinnerMes = findViewById<Spinner>(R.id.spinner_Mes)
        var Spinner_Mes = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mes)
        spinnerMes.adapter = Spinner_Mes

        //Spinner Año
        val año = ArrayList<String>()
        for (i in 1980 until 2022) {
            año.add(i.toString())
        }

        val spinnerAño = findViewById<Spinner>(R.id.spinner_Año)
        var Spinner_Año = ArrayAdapter(this, android.R.layout.simple_list_item_1, año)
        spinnerAño.adapter = Spinner_Año

        val button_Generar = findViewById<Button>(R.id.button_Generar)
        val button_Limpiar = findViewById<Button>(R.id.button_Limpiar)


        button_Generar.setOnClickListener {

            val curp = findViewById<TextView>(R.id.textView_Curp)
            val nombre = findViewById<EditText>(R.id.editText_Nombre).text
            val apellidoPaterno = findViewById<EditText>(R.id.editText_Papellido).text
            val apellidoMaterno = findViewById<EditText>(R.id.editText_Sapellido).text
            val estado = spinnerEstado.selectedItem.toString()
            val sexo = spinnerSexo.selectedItem.toString()
            val dia = spinnerDia.selectedItem.toString()
            val mes = spinnerMes.selectedItem.toString()
            val año = spinnerAño.selectedItem.toString()
            var vocalpa = ""
            var conspa = ""
            var consma = ""
            var consna = ""
            var apellidoVocalP = consonante(apellidoPaterno.toString())
            val consonanteapellidoP = vocal(apellidoPaterno.toString())
            val consonanteapellidoM = vocal(apellidoMaterno.toString())
            val consonanteNombre = vocal(nombre.toString())


            //Primera vocal del apellido paterno
            if (apellidoPaterno[0].toLowerCase() == 'a' || apellidoPaterno[0].toLowerCase() == 'e' ||
                    apellidoPaterno[0].toLowerCase() == 'i' || apellidoPaterno[0].toLowerCase() == 'o' || apellidoPaterno[0].toLowerCase() == 'u') {
                vocalpa = apellidoVocalP[1].toString().toUpperCase()
            } else {
                vocalpa = apellidoVocalP[0].toString().toUpperCase()
            }

            //Consonante del apellido paterno
            if (apellidoPaterno[0].toLowerCase() == 'a' || apellidoPaterno[0].toLowerCase() == 'e' ||
                    apellidoPaterno[0].toLowerCase() == 'i' || apellidoPaterno[0].toLowerCase() == 'o' || apellidoPaterno[0].toLowerCase() == 'u') {
                conspa = consonanteapellidoP[0].toString().toUpperCase()
            } else {
                conspa = consonanteapellidoP[1].toString().toUpperCase()
            }

            ////Consonante del apellido materno
            if (apellidoMaterno[0].toLowerCase() == 'a' || apellidoMaterno[0].toLowerCase() == 'e' ||
                    apellidoMaterno[0].toLowerCase() == 'i' || apellidoMaterno[0].toLowerCase() == 'o' || apellidoMaterno[0].toLowerCase() == 'u') {
                consma = consonanteapellidoM[0].toString().toUpperCase()
            } else {
                consma = consonanteapellidoM[1].toString().toUpperCase()
            }

            ////Consonante del nombre
            if (nombre[0].toLowerCase() == 'a' || nombre[0].toLowerCase() == 'e' || nombre[0].toLowerCase() == 'i' ||
                    nombre[0].toLowerCase() == 'o' || nombre[0].toLowerCase() == 'u') {
                consna = consonanteNombre[0].toString().toUpperCase()
            }
            else {
                consna = consonanteNombre[1].toString().toUpperCase()
            }

                var letra1 = apellidoPaterno[0].toString().toUpperCase()
                var letra3 = apellidoMaterno[0].toString().toUpperCase()
                var letra4 = nombre[0].toString().toUpperCase()
                var valor8 = dia
                var valor7 = mes
                var valor5 = año[2]
                var valor6 = año[3]
                var valor9 = sexo[0]
                var valor10 = estado[0]
                var valor11 = estado[1]

                val homoclave = arrayOf("1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L",
                    "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")

                val random1 = homoclave.random()
                val random2 = homoclave.random()
                val random3 = homoclave.random()

                curp.text = letra1 + vocalpa + letra3 + letra4 + valor5 + valor6 + valor7 + valor8 + valor9 + valor10 + valor11 + conspa + consma + consna + random1 + random2 + random3
            }

        button_Limpiar.setOnClickListener {
            var nombre = findViewById<EditText>(R.id.editText_Nombre)
            nombre.text.clear()
            var apellidoPaterno = findViewById<EditText>(R.id.editText_Papellido)
            apellidoPaterno.text.clear()
            var apellidoMaterno = findViewById<EditText>(R.id.editText_Sapellido)
            apellidoMaterno.text.clear()
            var curp = findViewById<TextView>(R.id.textView_Curp)
            curp.setText("")
            var spinnerSexo = findViewById<Spinner>(R.id.spinner_Sexo)
            spinnerSexo.setSelection(0)
            var spinnerEstado = findViewById<Spinner>(R.id.spinner_Estado)
            spinnerEstado.setSelection(0)
            var spinnerDia = findViewById<Spinner>(R.id.spinner_Dia)
            spinnerDia.setSelection(0)
            var spinnerMes = findViewById<Spinner>(R.id.spinner_Mes)
            spinnerMes.setSelection(0)
            var spinnerAño = findViewById<Spinner>(R.id.spinner_Año)
            spinnerAño.setSelection(0)

        }
    }

    fun consonante( text: String ): String {
        val result = StringBuilder()
        for ( char in text ) {
            if ( !"bcdfghjklmnñpqrstvwxyz".contains(char.toLowerCase()) ) {
                result.append( char )
            }
        }
        return result.toString()
    }

    fun vocal( text: String ): String {
        val result = StringBuilder()
        for ( char in text ) {
            if ( !"aeiou".contains(char.toLowerCase()) ) {
                result.append( char )
            }
        }
        return result.toString()
    }
}
