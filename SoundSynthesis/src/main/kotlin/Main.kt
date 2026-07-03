import javax.sound.sampled.AudioFormat
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.SourceDataLine
import kotlin.math.max
import kotlin.math.sin

fun sine(phase: Double): Double {
    return sin(phase)
}


fun normalize(samples: DoubleArray) {
    val max = samples.max()
    for (i in samples.indices) {
        samples[i] /= max
    }
}


fun main() {
    val sampleRate = 44100
    val duration = 1.0
    val bitDepth = 16
    val totalSamples = (sampleRate * duration).toInt()
    val frequency1 = 220.0
    val phaseIncrement1 = 2 * Math.PI * frequency1 / sampleRate
    val frequency2 = 329.63
    val phaseIncrement2 = 2 * Math.PI * frequency2 / sampleRate
    val samples1 = DoubleArray(totalSamples) { 0.0 }
    val samples2 = DoubleArray(totalSamples) { 0.0 }

    for(n in samples1.indices) {
        samples1[n] = sine(n * phaseIncrement1 % (2 * Math.PI))
    }

    for(n in samples2.indices) {
        samples2[n] = sine(n * phaseIncrement2 % (2 * Math.PI))
    }

    val samples = DoubleArray(totalSamples)

    for (i in samples.indices) {
        samples[i] = samples1[i] + samples2[i]
    }

    normalize(samples)

    val format = AudioFormat(sampleRate.toFloat(), bitDepth, 1, true, false)
    val line: SourceDataLine = AudioSystem.getSourceDataLine(format)
    line.open(format)
    line.start()

    val buffer = ByteArray(totalSamples * 2)
    for(i in samples.indices) {
        val pcmValue = (samples[i] * Short.MAX_VALUE).toInt()
        buffer[i * 2] = pcmValue.toByte()
        buffer[i * 2 + 1] = (pcmValue shr 8).toByte()
    }

    line.write(buffer, 0, buffer.size)
    line.drain()   // block until every sample has finished playing
    line.stop()
    line.close()
}