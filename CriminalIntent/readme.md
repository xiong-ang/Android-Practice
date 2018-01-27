# CriminalIntent          
> Android权威指南第三版7-8章练习                
## Fragment                 
> 采用Fragment而不是Activity管理应用UI，可以绕开Android系统Activity使用规则的限制，增加UI设计的灵活性             
容纳单个Fragment的Activity抽象类：                 
```
public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_container);

        if(fragment==null)
        {
            fragment=createFragment();
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
    protected abstract Fragment createFragment();
}
```
## 使用RecyclerView显示列表               
### RecyclerView        
> RecyclerView的任务仅限于回收和定位屏幕上的View         
### ViewHolder       
> 容纳View视图               
### Adapter                 
> Adapter负责创建必要的ViewHolder以及绑定ViewHolder至模型层数据    
### 各成员关系：
![](https://github.com/xiong-ang/Android-Practice/blob/master/CriminalIntent/RecyclerView.PNG)