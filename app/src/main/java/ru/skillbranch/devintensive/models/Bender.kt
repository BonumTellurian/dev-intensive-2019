package ru.skillbranch.devintensive.models

class Bender(var status:Status = Status.NORMAL, var question:Question = Question.NAME){

    fun askQuestion(): String = when(question){
        Question.NAME ->Question.NAME.question
        Question.PROFESSION ->Question.PROFESSION.question
        Question.MATERIAL ->Question.MATERIAL.question
        Question.BDAY ->Question.BDAY.question
        Question.SERIAL ->Question.SERIAL.question
        Question.IDLE ->Question.IDLE.question

    }

    fun listenAnswer(answer:String) : Pair<String, Triple<Int, Int, Int>> {

        return if(question.answers.contains(answer)){
            question = question.nextQuestion()
            "Отлично - ты справился\n${question.question}" to status.color
        } else {
            if (status == Status.CRITICAL) {
                    status = Status.NORMAL
                    question = Question.NAME
                    "Это неправильный ответ. Давай все по новой\\n${question.question}" to status.color
                }
            else {

                status = status.nextStatus()
                "Это неправильный ответ\n${question.question}" to status.color
            }
        }

//        return when (question) {
//            question.answers.contains(answer) ->
//                question = question.nextQuestion()
//            "Отлично - ты справился\n${question.question}" to status.color
//            else -> {
//                if status == Status.CRITICAL {
//                    status = Status.NORMAL
//                    question = Question.NAME
//                    "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
//                }
//                else {
//                    status = status.nextStatus()
//                    "Это неправильный ответ\n${question.question}" to status.color
//                }
//            }
//        }
////
//        return when(question){
//
//        }
//            question.answers.contains(answer)
//            question.answers.contains(answer)
//        }

//        return if(question.answers.contains(answer) && ! Question.IDLE) {
//            question = question.nextQuestion()
//            "Отлично - ты справился\n${question.question}" to status.color
//        } else {
//            status = status.nextStatus()
//            "Это неправильный ответ\n${question.question}" to status.color
//        }

//        return if(question.answers.contains(answer)){
//            question = question.nextQuestion()
//            "Отлично - ты справился\n${question.question}" to status.color
//        } else {
//            status = status.nextStatus()
//            "Это неправильный ответ\n${question.question}" to status.color
//        }

    }

    enum class Status(val color : Triple<Int, Int, Int>){
        NORMAL(Triple(255,255,255)),
        WARNING(Triple(255,120,0)),
        DANGER(Triple(255,60,60)),
        CRITICAL(Triple(255,0,0));

        fun nextStatus():Status{
            return if(this.ordinal < values().lastIndex){
                    values()[this.ordinal + 1]
                } else {
                    values()[0]
                }
        }
    }

    enum class Question(val question:String, val answers:List<String>){
        NAME("Как меня зовут?", listOf("бендер", "bender")){
            override fun nextQuestion(): Question = PROFESSION
//            override fun validateAnswer(): Boolean = Regex(pattern = "[A-Z]").matches(input = answers.toString())
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender")){
            override fun nextQuestion(): Question = MATERIAL
//            override fun validateAnswer(): Boolean = Regex(pattern = "[a-z]").matches(input = answers.toString())

        },
        MATERIAL("Из чего я сделан?", listOf("метал", "дерево", "metal", "iron", "wood")){
            override fun nextQuestion(): Question = BDAY
//            override fun validateAnswer(): Boolean = Regex(pattern = """\D""").matches(input = answers.toString())

        },
        BDAY("Когда меня создали?", listOf("2993")){
            override fun nextQuestion(): Question = SERIAL
//            override fun validateAnswer(): Boolean = Regex(pattern = """\d""").matches(input = answers.toString())

        },
        SERIAL("Мой серийный номер?", listOf("2716057")){
            override fun nextQuestion(): Question = IDLE
//            override fun validateAnswer(): Boolean = Regex(pattern = "[0-9]{7}").matches(input = answers.toString())

        },
        IDLE("На этом все, вопросов больше нет", listOf()){
            override fun nextQuestion(): Question = IDLE
//            override fun validateAnswer(): Boolean = true

        };

        abstract fun nextQuestion():Question
//        abstract fun validateAnswer(answers: String): Boolean

//        fun validate(question: String) : Boolean{
//            return when(this){
//                NAME -> Regex(pattern = "[A-Z]").matches(input = question)
//                PROFESSION -> Regex(pattern = "[a-z]").matches(input=question)
//                MATERIAL -> Regex(pattern = """\D""").matches(input=question)
//                BDAY  -> Regex(pattern = """\d""").matches(input=question)
//                SERIAL -> Regex(pattern = "[0-9]{7}").matches(input=question)
//                IDLE -> true
//            }
//        }
    }

//    enum class Validate(val question:String, val answers:List<String>){
//        NAME,
//        PROFESSION,
//        MATERIAL,
//        BDAY,
//        SERIAL,
//        IDLE;
//
//        fun valid(question: String) : Boolean{
//            return when(this){
//                NAME -> Regex(pattern = "[A-Z]").matches(input = question)
//                PROFESSION -> Regex(pattern = "[a-z]").matches(input=question)
//                MATERIAL -> Regex(pattern = """\D""").matches(input=question)
//                BDAY  -> Regex(pattern = """\d""").matches(input=question)
//                SERIAL -> Regex(pattern = "[0-9]{7}").matches(input=question)
//                IDLE -> true
//            }
//        }
//
//        open fun promt() : String {
//            return when(this){
//                NAME -> "Имя должно начинаться с заглавной буквы"
//                PROFESSION -> "Профессия должна начинаться со строчной буквы"
//                MATERIAL -> "Материал не должен содержать цифр"
//                BDAY -> "Год моего рождения должен содержать только цифры"
//                SERIAL -> "Серийный номер содержит только цифры, и их 7"
//                IDLE -> ""
//            }
//        }
//
//    }
}