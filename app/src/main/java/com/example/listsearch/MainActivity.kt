package com.example.listsearch

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchEditText = findViewById<EditText>(R.id.searchEditText)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Khởi tạo danh sách sinh viên
        studentList = listOf(
                Student("Nguyen Van A", "20210001"),
                Student("Tran Thi B", "20210002"),
                Student("Le Van C", "20210003"),
                Student("Pham Thi D", "20210004"),
                Student("Vo Van E", "20210005"),
                Student("Hoang Thi F", "20210006"),
                Student("Nguyen Thi G", "20210007"),
                Student("Le Van H", "20210008"),
                Student("Pham Van I", "20210009"),
                Student("Tran Van J", "20210010"),
                Student("Nguyen Van K", "20210011"),
                Student("Hoang Van L", "20210012"),
                Student("Le Thi M", "20210013"),
                Student("Vo Thi N", "20210014"),
                Student("Pham Thi O", "20210015"),
                Student("Tran Van P", "20210016"),
                Student("Nguyen Van Q", "20210017"),
                Student("Le Van R", "20210018"),
                Student("Pham Van S", "20210019"),
                Student("Vo Thi T", "20210020"),
                Student("Nguyen Van U", "20210021"),
                Student("Hoang Van V", "20210022"),
                Student("Tran Thi W", "20210023"),
                Student("Le Van X", "20210024"),
                Student("Pham Van Y", "20210025"),
                Student("Nguyen Van Z", "20210026"),
                Student("Hoang Van AA", "20210027"),
                Student("Tran Thi BB", "20210028"),
                Student("Le Van CC", "20210029"),
                Student("Pham Van DD", "20210030"),

        )

        // Khởi tạo Adapter và thiết lập cho RecyclerView
        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        // Thêm TextWatcher để tìm kiếm khi nhập từ khóa
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val keyword = s.toString().trim()
                if (keyword.length > 2) {
                    filterList(keyword)
                } else {
                    studentAdapter.updateList(studentList)  // Hiển thị toàn bộ danh sách nếu < 3 ký tự
                }
            }
        })
    }

    private fun filterList(keyword: String) {
        val filteredList = studentList.filter {
            it.name.contains(keyword, ignoreCase = true) || it.studentId.contains(keyword, ignoreCase = true)
        }
        studentAdapter.updateList(filteredList)
    }
}
