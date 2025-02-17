package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DslTest : StringSpec({

    "introduce" {
        val person: Person = introduce {
            name("손재빈")
        }

        person.name shouldBe "손재빈"
    }

    "company" {
        val person: Person = introduce {
            name("손재빈")
            company("인프랩")
        }

        person.company shouldBe "인프랩"
    }

    "skills" {
        val person: Person = introduce {
            name("손재빈")
            skills {
                soft("A passion for problem solving")
                soft("Good communication skills")
                hard("Kotlin")
            }
        }

        person.skills shouldBe Skills(
            listOf(
                SoftSkill("A passion for problem solving"),
                SoftSkill("Good communication skills"),
                HardSkill("Kotlin")
            )
        )
    }

    "language" {
        val person: Person = introduce {
            name("손재빈")
            languages {
                "Korean" level 5
                "English" level 3
            }
        }

        person.languages shouldBe Languages(
            listOf(
                Language("Korean", 5),
                Language("English", 3),
            )
        )
    }

    "error" {
        val exception = shouldThrow<IllegalArgumentException> {
            introduce {
            }
        }

        exception.message shouldBe "이름을 입력해주세요"
    }
})
