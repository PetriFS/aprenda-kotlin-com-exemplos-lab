/*Escola de idiomas YeasyTell
 * 
 * Comecei sem usar a classe estilo enum, pela dificuldade que estava tendo em inclementar o programa, 
 * porém após introduzir a classe enum, consegui entender o seu uso na pratica, pois não entendia o conceito
 * que a mesma tinha. Pude constatar a praticidade de usa-la*/
enum class NivelCurso {   //então mantive a ideia de inicio, colocando a classe no nível
    BÁSICO,
    INTERMEDIÁRIO,
    AVANÇADO
}
/*A classe Curso poderia ter mais parametros, como o conteúdo, programação, grade de materias*/
data class Curso(
    val nivel: NivelCurso, 
    val duracaoMeses: Int,
    val modulos: List<Modulo> 
    )
/*Usei o comando List para modulo, porém acredito que poderia ter uma outra maneira caso o programa fosse 
 * mais elaborado, facilitando a manipulação do objeto*/
data class Modulo(val nome: String)
/*A classe Usuario poderia ter muitos parametros acrescentados em caso de um programa usual, número de
 * documento, idade, e demais dados de cadastro chamando
 * uma função POO para validar dados, bem como usuários do próprio sistema*/
data class Usuario(val matricula: Int, val nome: String, val cursosInscritos: List<Curso>, val moduloInscrito: List<Modulo>)
fun main() {
    val modulos = listOf(
        Modulo("Módulo 1"),
        Modulo("Módulo 2"),
        Modulo("Módulo 3"),
        Modulo("Módulo 4"),
        Modulo("Módulo 5"),
    )
    val cursoBasico = Curso(NivelCurso.BÁSICO, 3, modulos)
    val cursoIntermediario = Curso(NivelCurso.INTERMEDIÁRIO, 3, modulos)
    val cursoAvancado = Curso(NivelCurso.AVANÇADO, 3, modulos)
    //cadastrando os primeiros usuarios
    var contador: Int = 1
    val usuario1 = Usuario(contador++, "João", listOf(cursoBasico), listOf(modulos[2])) 
    /*Aqui tive mais um aprendizado na pratica, pois fui atualizar a lista e aprendi a diferença
     * entre mutableListOf e ListOf :)*/
    val usuarios = mutableListOf(usuario1)
    val usuario2 = Usuario(contador++, "Maria", listOf(cursoIntermediario), listOf(modulos[0]))
    usuarios.add(usuario2)
    val instituicaoCursos = listOf(cursoBasico, cursoIntermediario, cursoAvancado)
    /*Listando os cursos de inglês, poderia acrescentar outros cursos, com número de modulos e duração
     * diferente usando a base das classes*/
    println("Cursos de Inglês da Instituição YeasyTell:")
    instituicaoCursos.forEach { 
        curso ->println("${curso.nivel} ${curso.duracaoMeses} meses")
        if(curso.nivel == NivelCurso.BÁSICO){
           curso.modulos.forEach { modulo ->println(" - ${modulo.nome}")}
        }
        if(curso.nivel == NivelCurso.INTERMEDIÁRIO){
           curso.modulos.forEach { modulo ->println(" - ${modulo.nome}")}
        }
        if(curso.nivel == NivelCurso.AVANÇADO){
           curso.modulos.forEach { modulo ->println(" - ${modulo.nome}")}
        }
    }
    // Listando os usuários, nível do curso e modulo   
    println("\nUsuários e seus cursos e módulos inscritos:\n")
    usuarios.forEach { 
        usuario ->print("${usuario.matricula} - ${usuario.nome} está cursando o ")
        usuario.cursosInscritos.forEach { 
            curso ->print("nível ${curso.nivel}")
        }
    usuario.moduloInscrito.forEach { 
        modulo ->println(" no ${modulo.nome}")
    }
    println("----------------------------------------------------------------------------------")
}
    //testando mais funções
    println("\n Atualizações: \n")
    //Adicionando mais usuarios
    val usuario3 = Usuario(contador++, "Alexandre", listOf(cursoAvancado), listOf(modulos[4])) 
    usuarios.add(usuario3)
    val usuario4 = Usuario(contador++, "Marcia", listOf(cursoIntermediario), listOf(modulos[1])) 
    usuarios.add(usuario4)
    //Atualizando, agora Maria está no modulo 2
    usuarios[1]= Usuario(2, "Maria", listOf(cursoIntermediario), listOf(modulos[1]))
    //Mostrando as atualizações
   println("\nUsuários e seus cursos e módulos inscritos (atualizado):\n")
    usuarios.forEach { 
        usuario ->print("${usuario.matricula} - ${usuario.nome} está cursando o ")
        usuario.cursosInscritos.forEach { 
            curso ->print("nível ${curso.nivel}")
        }
    usuario.moduloInscrito.forEach { 
        modulo ->println(" no ${modulo.nome}")
    }
    println("----------------------------------------------------------------------------------")
    }    
}
