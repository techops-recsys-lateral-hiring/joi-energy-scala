package service

import org.scalatest.{FlatSpec, Matchers}

class AccountServiceTest extends FlatSpec with Matchers {

  val PRICE_PLAN_ID = "price-plan-id"
  val SMART_METER_ID = "smart-meter-id"
  val accountService = new AccountService(Map(SMART_METER_ID -> PRICE_PLAN_ID))

  "getPricePlanIdForSmartMeterId" should "return pricePlan for smartMeterId if mapping exists" in {
    accountService.getPricePlanIdForSmartMeterId(SMART_METER_ID) should be (Some(PRICE_PLAN_ID))
  }

  "getPricePlanIdForSmartMeterId" should "return empty optional for nonexistent id" in {
    val nonExistentSmartMeterId = "not" + SMART_METER_ID
    accountService.getPricePlanIdForSmartMeterId(nonExistentSmartMeterId) should be (None)
  }
}
