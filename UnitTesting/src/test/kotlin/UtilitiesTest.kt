import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import javax.management.DescriptorKey
import kotlin.test.Test
import kotlin.test.assertEquals

@DisplayName("All Utilities Test")
class UtilitiesTest {

    @Test
    @DisplayName("R should change to W")
    fun testFuddify() {
        assertEquals("Wabbit", fuddify("Rabbit"))
    }

    @Test
    @DisplayName("r should change to w")
    fun testFuddify2() {
        assertEquals("wabbit", fuddify("rabbit"))
    }

    @Test
    @DisplayName("empty string should throw exception")
    fun testEmptyString() {
        assertThrows<IllegalArgumentException> { fuddify("") }
    }
}