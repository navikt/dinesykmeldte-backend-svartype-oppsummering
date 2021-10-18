package no.nav.syfo.sykmelding.db

import no.nav.syfo.model.sykmelding.arbeidsgiver.ArbeidsgiverSykmelding
import no.nav.syfo.objectMapper
import org.postgresql.util.PGobject
import java.time.LocalDate
import java.time.OffsetDateTime

data class SykmeldingDbModel(
    val sykmeldingId: String,
    val pasientFnr: String,
    val pasientNavn: String,
    val orgnummer: String,
    val orgnavn: String?,
    val startdatoSykefravaer: LocalDate,
    val sykmelding: ArbeidsgiverSykmelding,
    val lest: Boolean,
    val timestamp: OffsetDateTime,
    val latestTom: LocalDate
)

fun ArbeidsgiverSykmelding.toPGObject() = PGobject().also {
    it.type = "json"
    it.value = objectMapper.writeValueAsString(this)
}
