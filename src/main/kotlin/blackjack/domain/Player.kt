package blackjack.domain

open class Player(
    val name: String,
    hand: Hand = Hand(emptyList(), Bet.EMPTY_BET)
) {
    var hand = hand
        private set

    val score: Score
        get() = Score(hand.cards)

    val canDrawCard: Boolean
        get() = !score.isBlackjack && !score.isBust

    fun addCard(card: Card) {
        hand = hand.addCard(card)
    }
}
