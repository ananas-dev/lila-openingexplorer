package lila.openingexplorer

import org.specs2.mutable._

import chess.Color

class EntryTest extends Specification {

  "entries" should {

    "not contain low rated games" in {
      val patzerGame = new GameRef("patzer00", Some(Color.White), SpeedGroup.Classical, 456)
      Entry.empty.withGameRef(patzerGame) mustEqual Entry.empty
    }

    "count total games" in {
      val g1 = new GameRef("g0000001", Some(Color.Black), SpeedGroup.Bullet, 2001)
      val g2 = new GameRef("g0000002", None, SpeedGroup.Bullet, 2002)

      Entry.empty.totalGames mustEqual 0
      Entry.fromGameRef(g1).totalGames mustEqual 1
      Entry.fromGameRef(g1).withGameRef(g2).totalGames mustEqual 2
    }

  }

}
