package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DataCustomer {
    private String slttipo,
            slttipo_identificacion,
            txtidentificacion,
            txtcodigo_sucursal,
            txtnombre,
            txtapellido,
            txtnombre_comercial,
            txtciudad,
            txtdireccion,
            txttelefono,
            txtcorreo_factura,
            slttipo_regimen,
            rbresponsabilidad_fiscal,
            txtindicativo,
            txttelefono1,
            txtcodigo_postal,
            txtnombre_contacto,
            txtapellidos_contacto,
            txtcorreo_contacto,
            txtcargo_contacto,
            txtindicativo_contacto,
            txttelefono_contacto;




    public static List<DataCustomer> setData(DataTable dataTable) {
        List<DataCustomer> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, DataCustomer.class));
        }
        return dates;
    }
}
