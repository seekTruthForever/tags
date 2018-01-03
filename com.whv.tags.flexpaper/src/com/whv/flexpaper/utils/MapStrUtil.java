package com.whv.flexpaper.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * mapת��Ϊ�ַ���������
 * ���ܣ�mapת�ַ�����listת�ַ�����map�Ƴ��ռ�ֵ
 * @author whv
 *
 */
public class MapStrUtil {
	/**
	 * ��������:map2str
	 * �������:map
	 * ����ֵ:String
	*/
	public static String map2str(Map<?, ?> map){
	  java.util.Map.Entry<?, ?> entry;
	  StringBuffer sb = new StringBuffer();
	  for(Iterator<?> iterator = map.entrySet().iterator(); iterator.hasNext();)
	  {
	    entry = (java.util.Map.Entry<?, ?>)iterator.next();
	      sb.append(entry.getKey().toString()).append( ":" );
	      if (entry.getValue()  instanceof String) {
	    	  if(null==entry.getValue()) {
	    		  sb.append("null").append (iterator.hasNext() ? "," : "");
	    	  }else {
	    		  String value = entry.getValue().toString().trim();
	    		  if(value.startsWith("'")&&value.endsWith("'")) {
	    			  sb.append(value).append (iterator.hasNext() ? "," : "");
	    		  }else {
	    			  sb.append("'");
	    			  sb.append(value);
	    			  sb.append("'");
	    			  sb.append (iterator.hasNext() ? "," : "");
	    		  }
	    	  }
			
		}else  if (entry.getValue() instanceof List<?>) {
			 if(null==entry.getValue()) {
	    		  sb.append("null").append (iterator.hasNext() ? "," : "");
	    	  }else {
	    		  sb.append(list2str((List<?>) entry.getValue())).append (iterator.hasNext() ? "," : "");
	    	  }
        } else if (entry.getValue() instanceof Map<?, ?>) {
        	 if(null==entry.getValue()) {
	    		  sb.append("null").append (iterator.hasNext() ? "," : "");
	    	  }else {
	    		  sb.append(map2str((Map<?, ?>) entry.getValue())).append (iterator.hasNext() ? "," : "");
	    	  }
        } else{
			 sb.append(entry.getValue()).append (iterator.hasNext() ? "," : "");  
		}
	  }
	  return sb.toString();
	}
	 /**
     * Listת��String
     * 
     * @param list
     *            :��Ҫת����List
     * @return Stringת������ַ���
     */
    public static String list2str(List<?> list) {
    	Object obj;
        StringBuffer sb = new StringBuffer();
        if (list != null && list.size() > 0) {
        	 for(Iterator<?> iterator = list.iterator(); iterator.hasNext();){
        		 obj = iterator.next();
                // ���ֵ��list����������Լ�
                if (obj  instanceof String) {
      	    	  if(null==obj) {
      	    		  sb.append("null").append (iterator.hasNext() ? "," : "");
      	    	  }else {
      	    		  String value = obj.toString().trim();
      	    		  if(value.startsWith("'")&&value.endsWith("'")) {
      	    			  sb.append(value).append (iterator.hasNext() ? "," : "");
      	    		  }else {
      	    			  sb.append("'");
      	    			  sb.append(value);
      	    			  sb.append("'");
      	    			  sb.append (iterator.hasNext() ? "," : "");
      	    		  }
      	    	  }
      	    	  
      			
      		}else if (obj instanceof List) {
                    sb.append(list2str((List<?>) obj));
                    sb.append (iterator.hasNext() ? "," : "");
                } else if (obj instanceof Map) {
                    sb.append(map2str((Map<?, ?>) obj));
                    sb.append (iterator.hasNext() ? "," : "");
                } else {
                    sb.append(obj);
                    sb.append (iterator.hasNext() ? "," : "");
                }
            }
        }
        return sb.toString();
    }
	/**
	 * ��������:str2map
	 * �������:mapString
	 * ����ֵ:Map
	*/
	public static Map str2map(String mapString){
	  Map map = new HashMap();
	  java.util.StringTokenizer items;
	  for(StringTokenizer entrys = new StringTokenizer(mapString, ",");entrys.hasMoreTokens(); 
	    map.put(items.nextToken().trim(), items.hasMoreTokens() ? ((Object) (items.nextToken().trim())) : null))
	      items = new StringTokenizer(entrys.nextToken().trim(), ":");
	  return map;
	}
	
	/** 
     * �Ƴ�map�п�key����value��ֵ 
     * @param map 
     */  
    public static void removeNullEntry(Map map){  
        removeNullKey(map);  
        removeNullValue(map);  
    }  
      
    /** 
     * �Ƴ�map�Ŀ�key 
     * @param map 
     * @return 
     */  
    public static void removeNullKey(Map map){  
        Set set = map.keySet();  
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {  
            Object obj = (Object) iterator.next();  
            remove(obj, iterator);  
        }  
    }  
      
    /** 
     * �Ƴ�map�е�value��ֵ 
     * @param map 
     * @return 
     */  
    public static void removeNullValue(Map map){  
        Set set = map.keySet();  
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {  
            Object obj = (Object) iterator.next();  
            Object value =(Object)map.get(obj);  
            remove(value, iterator);  
        }  
    }  
      
    /** 
     * Iterator �ǹ�����һ���������߳��У�����ӵ��һ�� mutex ����  
     * Iterator ������֮��Ὠ��һ��ָ��ԭ������ĵ�����������ԭ���Ķ������������仯ʱ���������������ݲ���ͬ���ı䣬 
     * ���Ե�����ָ�������ƶ���ʱ����Ҳ���Ҫ�����Ķ������԰��� fail-fast ԭ�� Iterator �������׳� java.util.ConcurrentModificationException �쳣�� 
     * ���� Iterator �ڹ�����ʱ���ǲ����������Ķ��󱻸ı�ġ� 
     * �������ʹ�� Iterator ����ķ��� remove() ��ɾ������ Iterator.remove() ��������ɾ����ǰ���������ͬʱά��������һ���ԡ� 
     * @param obj 
     * @param iterator 
     */  
    private static void remove(Object obj,Iterator iterator){  
        if(obj instanceof String){  
            String str = (String)obj;  
            if(str==null || str.isEmpty()){  
                iterator.remove();  
            }  
        }else if(obj instanceof Collection){  
            Collection col = (Collection)obj;  
            if(col==null||col.isEmpty()){  
                iterator.remove();  
            }  
              
        }else if(obj instanceof Map){  
            Map temp = (Map)obj;  
            if(temp==null||temp.isEmpty()){  
                iterator.remove();  
            }  
              
        }else if(obj instanceof Object[]){  
            Object[] array =(Object[])obj;  
            if(array==null||array.length<=0){  
                iterator.remove();  
            }  
        }else{  
            if(obj==null){  
                iterator.remove();  
            }  
        }  
    }  
}
