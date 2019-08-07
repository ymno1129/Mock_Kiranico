package com.kiranico.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.kiranico.misc.AmmoInfoSingle;

@Entity
@Access(AccessType.FIELD)
public class AmmoInfo {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "deviation")
	private String deviation;
	@Column(name = "special")
	private String special;
	@Column(name = "normal1_clip")
	private Integer normal1_clip;
	@Column(name = "normal1_rapid")
	private Boolean normal1_rapid;
	@Column(name = "normal1_recoil")
	private Integer normal1_recoil;
	@Column(name = "normal1_reload")
	private String normal1_reload;
	
	@Column(name = "normal2_clip")
	private Integer normal2_clip;
	@Column(name = "normal2_rapid")
	private Boolean normal2_rapid;
	@Column(name = "normal2_recoil")
	private Integer normal2_recoil;
	@Column(name = "normal2_reload")
	private String normal2_reload;
	
	@Column(name = "normal3_clip")
	private Integer normal3_clip;
	@Column(name = "normal3_rapid")
	private Boolean normal3_rapid;
	@Column(name = "normal3_recoil")
	private Integer normal3_recoil;
	@Column(name = "normal3_reload")
	private String normal3_reload;
	
	@Column(name = "pierce1_clip")
	private Integer pierce1_clip;
	@Column(name = "pierce1_rapid")
	private Boolean pierce1_rapid;
	@Column(name = "pierce1_recoil")
	private Integer pierce1_recoil;
	@Column(name = "pierce1_reload")
	private String pierce1_reload;
	
	@Column(name = "pierce2_clip")
	private Integer pierce2_clip;
	@Column(name = "pierce2_rapid")
	private Boolean pierce2_rapid;
	@Column(name = "pierce2_recoil")
	private Integer pierce2_recoil;
	@Column(name = "pierce2_reload")
	private String pierce2_reload;
	
	@Column(name = "pierce3_clip")
	private Integer pierce3_clip;
	@Column(name = "pierce3_rapid")
	private Boolean pierce3_rapid;
	@Column(name = "pierce3_recoil")
	private Integer pierce3_recoil;
	@Column(name = "pierce3_reload")
	private String pierce3_reload;
	
	@Column(name = "spread1_clip")
	private Integer spread1_clip;
	@Column(name = "spread1_rapid")
	private Boolean spread1_rapid;
	@Column(name = "spread1_recoil")
	private Integer spread1_recoil;
	@Column(name = "spread1_reload")
	private String spread1_reload;
	
	@Column(name = "spread2_clip")
	private Integer spread2_clip;
	@Column(name = "spread2_rapid")
	private Boolean spread2_rapid;
	@Column(name = "spread2_recoil")
	private Integer spread2_recoil;
	@Column(name = "spread2_reload")
	private String spread2_reload;
	
	@Column(name = "spread3_clip")
	private Integer spread3_clip;
	@Column(name = "spread3_rapid")
	private Boolean spread3_rapid;
	@Column(name = "spread3_recoil")
	private Integer spread3_recoil;
	@Column(name = "spread3_reload")
	private String spread3_reload;
	
	@Column(name = "sticky1_clip")
	private Integer sticky1_clip;
	@Column(name = "sticky1_recoil")
	private Integer sticky1_recoil;
	@Column(name = "sticky1_reload")
	private String sticky1_reload;
	
	@Column(name = "sticky2_clip")
	private Integer sticky2_clip;
	@Column(name = "sticky2_recoil")
	private Integer sticky2_recoil;
	@Column(name = "sticky2_reload")
	private String sticky2_reload;
	
	@Column(name = "sticky3_clip")
	private Integer sticky3_clip;
	@Column(name = "sticky3_recoil")
	private Integer sticky3_recoil;
	@Column(name = "sticky3_reload")
	private String sticky3_reload;
	
	@Column(name = "cluster1_clip")
	private Integer cluster1_clip;
	@Column(name = "cluster1_recoil")
	private Integer cluster1_recoil;
	@Column(name = "cluster1_reload")
	private String cluster1_reload;
	
	@Column(name = "cluster2_clip")
	private Integer cluster2_clip;
	@Column(name = "cluster2_recoil")
	private Integer cluster2_recoil;
	@Column(name = "cluster2_reload")
	private String cluster2_reload;
	
	@Column(name = "cluster3_clip")
	private Integer cluster3_clip;
	@Column(name = "cluster3_recoil")
	private Integer cluster3_recoil;
	@Column(name = "cluster3_reload")
	private String cluster3_reload;
	
	@Column(name = "recover1_clip")
	private Integer recover1_clip;
	@Column(name = "recover1_recoil")
	private Integer recover1_recoil;
	@Column(name = "recover1_reload")
	private String recover1_reload;
	
	@Column(name = "recover2_clip")
	private Integer recover2_clip;
	@Column(name = "recover2_recoil")
	private Integer recover2_recoil;
	@Column(name = "recover2_reload")
	private String recover2_reload;
	
	@Column(name = "poison1_clip")
	private Integer poison1_clip;
	@Column(name = "poison1_recoil")
	private Integer poison1_recoil;
	@Column(name = "poison1_reload")
	private String poison1_reload;
	
	@Column(name = "poison2_clip")
	private Integer poison2_clip;
	@Column(name = "poison2_recoil")
	private Integer poison2_recoil;
	@Column(name = "poison2_reload")
	private String poison2_reload;
	
	@Column(name = "paralysis1_clip")
	private Integer paralysis1_clip;
	@Column(name = "paralysis1_recoil")
	private Integer paralysis1_recoil;
	@Column(name = "paralysis1_reload")
	private String paralysis1_reload;
	
	@Column(name = "paralysis2_clip")
	private Integer paralysis2_clip;
	@Column(name = "paralysis2_recoil")
	private Integer paralysis2_recoil;
	@Column(name = "paralysis2_reload")
	private String paralysis2_reload;
	
	@Column(name = "sleep1_clip")
	private Integer sleep1_clip;
	@Column(name = "sleep1_recoil")
	private Integer sleep1_recoil;
	@Column(name = "sleep1_reload")
	private String sleep1_reload;
	
	@Column(name = "sleep2_clip")
	private Integer sleep2_clip;
	@Column(name = "sleep2_recoil")
	private Integer sleep2_recoil;
	@Column(name = "sleep2_reload")
	private String sleep2_reload;
	
	@Column(name = "exhaust1_clip")
	private Integer exhaust1_clip;
	@Column(name = "exhaust1_rapid")
	private Boolean exhaust1_rapid;
	@Column(name = "exhaust1_recoil")
	private Integer exhaust1_recoil;
	@Column(name = "exhaust1_reload")
	private String exhaust1_reload;
	
	@Column(name = "exhaust2_clip")
	private Integer exhaust2_clip;
	@Column(name = "exhaust2_rapid")
	private Boolean exhaust2_rapid;
	@Column(name = "exhaust2_recoil")
	private Integer exhaust2_recoil;
	@Column(name = "exhaust2_reload")
	private String exhaust2_reload;
	
	@Column(name = "flaming_clip")
	private Integer flaming_clip;
	@Column(name = "flaming_rapid")
	private Boolean flaming_rapid;
	@Column(name = "flaming_recoil")
	private Integer flaming_recoil;
	@Column(name = "flaming_reload")
	private String flaming_reload;
	
	@Column(name = "water_clip")
	private Integer water_clip;
	@Column(name = "water_rapid")
	private Boolean water_rapid;
	@Column(name = "water_recoil")
	private Integer water_recoil;
	@Column(name = "water_reload")
	private String water_reload;
	
	@Column(name = "freeze_clip")
	private Integer freeze_clip;
	@Column(name = "freeze_rapid")
	private Boolean freeze_rapid;
	@Column(name = "freeze_recoil")
	private Integer freeze_recoil;
	@Column(name = "freeze_reload")
	private String freeze_reload;
	
	@Column(name = "thunder_clip")
	private Integer thunder_clip;
	@Column(name = "thunder_rapid")
	private Boolean thunder_rapid;
	@Column(name = "thunder_recoil")
	private Integer thunder_recoil;
	@Column(name = "thunder_reload")
	private String thunder_reload;
	
	@Column(name = "dragon_clip")
	private Integer dragon_clip;
	@Column(name = "dragon_recoil")
	private Integer dragon_recoil;
	@Column(name = "dragon_reload")
	private String dragon_reload;
	
	@Column(name = "slicing_clip")
	private Integer slicing_clip;
	@Column(name = "slicing_recoil")
	private Integer slicing_recoil;
	@Column(name = "slicing_reload")
	private String slicing_reload;
	
	@Column(name = "wyvern_clip")
	private Integer wyvern_clip;
	@Column(name = "wyvern_reload")
	private String wyvern_reload;
	
	@Column(name = "demon_clip")
	private Integer demon_clip;
	@Column(name = "demon_recoil")
	private Integer demon_recoil;
	@Column(name = "demon_reload")
	private String demon_reload;
	
	@Column(name = "tranq_clip")
	private Integer tranq_clip;
	@Column(name = "tranq_recoil")
	private Integer tranq_recoil;
	@Column(name = "tranq_reload")
	private String tranq_reload;

	@Override
	public String toString() {
		return "Binding successful";
	}
	
	public List<AmmoInfoSingle> getAmmoInfoLines(){
		AmmoInfoSingle norm1 = new AmmoInfoSingle("Normal 1", normal1_clip, normal1_rapid, normal1_recoil, normal1_reload);
		AmmoInfoSingle norm2 = new AmmoInfoSingle("Normal 2", normal2_clip, normal2_rapid, normal2_recoil, normal2_reload);
		AmmoInfoSingle norm3 = new AmmoInfoSingle("Normal 3", normal3_clip, normal3_rapid, normal3_recoil, normal3_reload);
		AmmoInfoSingle pc1 = new AmmoInfoSingle("Pierce 1", pierce1_clip, pierce1_rapid, pierce1_recoil, pierce1_reload);
		AmmoInfoSingle pc2 = new AmmoInfoSingle("Pierce 2", pierce2_clip, pierce2_rapid, pierce2_recoil, pierce2_reload);
		AmmoInfoSingle pc3 = new AmmoInfoSingle("Pierce 3", pierce3_clip, pierce3_rapid, pierce3_recoil, pierce3_reload);
		AmmoInfoSingle sp1 = new AmmoInfoSingle("Spread 1", spread1_clip, spread1_rapid, spread1_recoil, spread1_reload);
		AmmoInfoSingle sp2 = new AmmoInfoSingle("Spread 2", spread2_clip, spread2_rapid, spread2_recoil, spread2_reload);
		AmmoInfoSingle sp3 = new AmmoInfoSingle("Spread 3", spread3_clip, spread3_rapid, spread3_recoil, spread3_reload);
		AmmoInfoSingle stk1 = new AmmoInfoSingle("Sticky 1", sticky1_clip, false, sticky1_recoil, sticky1_reload);
		AmmoInfoSingle stk2 = new AmmoInfoSingle("Sticky 2", sticky2_clip, false, sticky2_recoil, sticky2_reload);
		AmmoInfoSingle stk3 = new AmmoInfoSingle("Sticky 3", sticky3_clip, false, sticky3_recoil, sticky3_reload);
		AmmoInfoSingle cls1 = new AmmoInfoSingle("Cluster 1", cluster1_clip, false, cluster1_recoil, cluster1_reload);
		AmmoInfoSingle cls2 = new AmmoInfoSingle("Cluster 2", cluster2_clip, false, cluster2_recoil, cluster2_reload);
		AmmoInfoSingle cls3 = new AmmoInfoSingle("Cluster 3", cluster3_clip, false, cluster3_recoil, cluster3_reload);
		AmmoInfoSingle rec1 = new AmmoInfoSingle("Recover 1", recover1_clip, false, recover1_recoil, recover1_reload);
		AmmoInfoSingle rec2 = new AmmoInfoSingle("Recover 2", recover2_clip, false, recover2_recoil, recover2_reload);
		AmmoInfoSingle poi1 = new AmmoInfoSingle("Poison 1", poison1_clip, false, poison1_recoil, poison1_reload);
		AmmoInfoSingle poi2 = new AmmoInfoSingle("Poison 2", poison2_clip, false, poison2_recoil, poison2_reload);
		AmmoInfoSingle par1 = new AmmoInfoSingle("Paralysis 1", paralysis1_clip, false, paralysis1_recoil, paralysis1_reload);
		AmmoInfoSingle par2 = new AmmoInfoSingle("Paralysis 2", paralysis2_clip, false, paralysis2_recoil, paralysis2_reload);
		AmmoInfoSingle slp1 = new AmmoInfoSingle("Sleep 1", sleep1_clip, false, sleep1_recoil, sleep1_reload);
		AmmoInfoSingle slp2 = new AmmoInfoSingle("Sleep 2", sleep2_clip, false, sleep2_recoil, sleep2_reload);
		AmmoInfoSingle exh1 = new AmmoInfoSingle("Exhaust 1", exhaust1_clip, false, exhaust1_recoil, exhaust1_reload);
		AmmoInfoSingle exh2 = new AmmoInfoSingle("Exhaust 2", exhaust2_clip, false, exhaust2_recoil, exhaust2_reload);
		AmmoInfoSingle flm = new AmmoInfoSingle("Flame", flaming_clip, flaming_rapid, flaming_recoil, flaming_reload);
		AmmoInfoSingle wat = new AmmoInfoSingle("Water", water_clip, water_rapid, water_recoil, water_reload);
		AmmoInfoSingle ice = new AmmoInfoSingle("Freeze", freeze_clip, freeze_rapid, freeze_recoil, freeze_reload);
		AmmoInfoSingle thun = new AmmoInfoSingle("Thunder", thunder_clip, thunder_rapid, thunder_recoil, thunder_reload);
		AmmoInfoSingle drag = new AmmoInfoSingle("Dragon", dragon_clip, false, dragon_recoil, dragon_reload);
		AmmoInfoSingle slic = new AmmoInfoSingle("Slicing", slicing_clip, false, slicing_recoil, slicing_reload);
		AmmoInfoSingle wyv = new AmmoInfoSingle("Wyvern", wyvern_clip, false, -4, wyvern_reload);
		AmmoInfoSingle dem = new AmmoInfoSingle("Demon", demon_clip, false, demon_recoil, demon_reload);
		AmmoInfoSingle arm = new AmmoInfoSingle("tranq", tranq_clip, false, tranq_recoil, tranq_reload);
		AmmoInfoSingle tranq = new AmmoInfoSingle("Tranq", tranq_clip, false, tranq_recoil, tranq_reload);
		List<AmmoInfoSingle> info_list = Arrays.asList( norm1, norm2, norm3, pc1, pc2, pc3, sp1, sp2, sp3, stk1, stk2, stk3, 
				cls1, cls2, cls3, rec1, rec2, poi1, poi2, par1, par2, slp1, slp2, exh1, exh2, flm, wat, ice, thun, drag, 
				slic, wyv, dem, arm, tranq);
		
		//Only display useable ammos.
		List<AmmoInfoSingle> filtered = new ArrayList<AmmoInfoSingle>();
		for (AmmoInfoSingle info : info_list) {
			if (info.getCapacity() == 0) continue;
			filtered.add(info);
		}
		return filtered;
	}
	
}
