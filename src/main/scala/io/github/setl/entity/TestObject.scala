package io.github.setl.entity

import io.github.setl.annotation.ColumnName

case class TestObject(
    _hoodie_commit_time: String,
    _hoodie_commit_seqno: String,
    _hoodie_record_key: String,
    _hoodie_partition_path: String,
    _hoodie_file_name: String,
    id: Int,
    create_uid: Int,
    create_date: BigInt,
    write_uid: Int,
    write_date: BigInt,
    manufacture_year_moved0: Int,
    model_id: Int,
    car_unique_number: String,
    vin: String,
    engine_number: String,
    manufacture_year: String,
    name: String,
    __deleted: String
)