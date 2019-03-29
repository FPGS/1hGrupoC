extends Area2D
signal cambiar_objetibo

func _ready():
	
	pass

func _input_event(viewport, event, shape_idx):
    if event is InputEventMouseButton \
    and event.button_index == BUTTON_LEFT \
    and event.is_pressed():
        self.on_click()

func on_click():
   emit_signal("cambiar_objetibo")
	