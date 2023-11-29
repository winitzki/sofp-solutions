# Copy solutions to source files.
for chapter in chapter[0-9][0-9]; do

     cat <<EOF1 > $chapter/src/test/scala/sofp/unit/Solutions.scala
package sofp.unit
import com.eed3si9n.expecty.Expecty.expect
import munit.FunSuite

class WorksheetsTest extends FunSuite {

EOF1
   for worksheet in $chapter/worksheets/*.scala; do

     cat <<EOF2 >> $chapter/src/test/scala/sofp/unit/Solutions.scala

  test("verify $worksheet") {
EOF2

    cat $worksheet >> $chapter/src/test/scala/sofp/unit/Solutions.scala

     cat <<EOF3 >> $chapter/src/test/scala/sofp/unit/Solutions.scala

  }
EOF3

  done

cat <<EOF4 >> $chapter/src/test/scala/sofp/unit/Solutions.scala

}
EOF4

done

sbt "$@"
